package pers.cgglyle.service.acconut.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import pers.cgglyle.common.annotaion.RedisCache;
import pers.cgglyle.common.base.model.BaseQuery;
import pers.cgglyle.common.base.service.impl.BaseServiceImpl;
import pers.cgglyle.common.response.PageResult;
import pers.cgglyle.service.acconut.mapper.GroupMapper;
import pers.cgglyle.service.acconut.mapper.UserMapper;
import pers.cgglyle.service.acconut.model.dto.GroupAddDto;
import pers.cgglyle.service.acconut.model.dto.GroupUpdateDto;
import pers.cgglyle.service.acconut.model.entity.GroupEntity;
import pers.cgglyle.service.acconut.model.entity.UserEntity;
import pers.cgglyle.service.acconut.model.query.GroupQuery;
import pers.cgglyle.service.acconut.model.vo.GroupVo;
import pers.cgglyle.service.acconut.service.GroupService;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 用户组服务成实现
 *
 * @author cgglyle
 * @date 2021-12-10 09:59
 */
@Service
public class GroupServiceImpl extends BaseServiceImpl<GroupMapper, GroupEntity> implements GroupService {

    private final UserMapper userMapper;

    public GroupServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public PageResult getPage(BaseQuery baseQuery) {
        GroupQuery groupQuery = (GroupQuery) baseQuery;
        QueryWrapper<GroupEntity> queryWrapper = new QueryWrapper<>();
        if (groupQuery.getGroupName() != null) {
            queryWrapper.like("group_name", groupQuery.getGroupName());
        }
        if (groupQuery.getGroupDescription() != null) {
            queryWrapper.like("group_description", groupQuery.getGroupDescription());
        }
        // 判断更新用户查询是否为空
        if (groupQuery.getUpdateUser() != null) {
            // 临时wrapper
            QueryWrapper<UserEntity> tempWrapper = new QueryWrapper<>();
            // 查询用户id
            tempWrapper.select("id", "user_name").like("user_name", groupQuery.getUpdateUser());
            List<UserEntity> list = userMapper.selectList(tempWrapper);
            // 循环加入wrapper
            for (UserEntity userEntity : list) {
                queryWrapper.or().eq("id", userEntity.getId());
            }
        }
        queryWrapper.orderByDesc("id");
        Page<GroupEntity> page = new Page<>(groupQuery.getPageNum(), groupQuery.getPageSize());
        Page<GroupEntity> data = baseMapper.selectPage(page, queryWrapper);
        List<GroupVo> collect = data.getRecords().stream().map(group -> {
            GroupVo groupVo = new GroupVo();
            if (group.getUpdateUser() != null) {
                UserEntity userEntity = userMapper.selectById(group.getUpdateUser());
                groupVo.setUpdateUser(userEntity.getUserName());
            }
            BeanUtils.copyProperties(group, groupVo);
            return groupVo;
        }).collect(Collectors.toList());
        return new PageResult(groupQuery.getPageNum(), groupQuery.getPageSize(), data.getTotal(), data.getPages(), collect);
    }

    @Override
    public boolean addGroup(GroupAddDto groupAddDto) {
        GroupEntity groupEntity = new GroupEntity();
        BeanUtils.copyProperties(groupAddDto, groupEntity);
        return this.add(groupEntity);
    }

    @Override
    public boolean updateGroup(GroupUpdateDto groupUpdateDto) {
        GroupEntity groupEntity = new GroupEntity();
        BeanUtils.copyProperties(groupUpdateDto, groupEntity);
        return this.update(groupEntity);
    }
}
