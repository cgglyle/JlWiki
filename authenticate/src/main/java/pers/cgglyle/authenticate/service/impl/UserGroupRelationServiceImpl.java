package pers.cgglyle.authenticate.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import pers.cgglyle.common.annotaion.RedisCache;
import pers.cgglyle.common.base.service.impl.BaseServiceImpl;
import pers.cgglyle.authenticate.mapper.UserGroupRelationMapper;
import pers.cgglyle.authenticate.model.dto.UserGroupRelationAddDto;
import pers.cgglyle.authenticate.model.entity.GroupEntity;
import pers.cgglyle.authenticate.model.entity.UserGroupRelationEntity;
import pers.cgglyle.authenticate.model.vo.UserGroupVo;
import pers.cgglyle.authenticate.service.GroupService;
import pers.cgglyle.authenticate.service.UserGroupRelationService;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cgglyle
 * @date 2021-12-10 13:38
 */
@Service
public class UserGroupRelationServiceImpl extends BaseServiceImpl<UserGroupRelationMapper, UserGroupRelationEntity> implements UserGroupRelationService {

    private final GroupService groupService;

    public UserGroupRelationServiceImpl(GroupService groupService) {
        this.groupService = groupService;
    }

    @Override
    public boolean addUserGroup(UserGroupRelationAddDto userGroupRelationAddDto) {
        UserGroupRelationEntity userGroupRelationEntity = new UserGroupRelationEntity();
        BeanUtils.copyProperties(userGroupRelationAddDto, userGroupRelationEntity);
        return super.add(userGroupRelationEntity);
    }

    @RedisCache
    @Override
    public List<Integer> getUserIdList(String userGroup) {
        QueryWrapper<GroupEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("group_name", userGroup);
        List<GroupEntity> list = groupService.list(queryWrapper);
        QueryWrapper<UserGroupRelationEntity> wrapper = new QueryWrapper<>();
        for (GroupEntity groupEntity : list) {
            wrapper.or().eq("group_id", groupEntity.getId());
        }
        List<UserGroupRelationEntity> userGroupRelationEntityList = list(wrapper);
        List<Integer> integers = new ArrayList<>();
        for (UserGroupRelationEntity userGroupRelationEntity : userGroupRelationEntityList) {
            integers.add(userGroupRelationEntity.getUserId());
        }
        return integers;
    }

    @RedisCache
    @Override
    public List<UserGroupVo> getUserGroupList(Integer id) {
        QueryWrapper<UserGroupRelationEntity> queryWrapper = new QueryWrapper<>();
        // 从 user_group_relation 表中查出 id 和 group_id
        queryWrapper.select("id", "group_id").eq("user_id", id);
        List<UserGroupRelationEntity> list = list(queryWrapper);
        List<UserGroupVo> userGroupVos = new ArrayList<>();
        for (UserGroupRelationEntity userGroupRelationEntity : list) {
            GroupEntity groupEntity = groupService.getById(userGroupRelationEntity.getGroupId());
            userGroupVos.add(new UserGroupVo(userGroupRelationEntity.getId(), groupEntity.getGroupName()));
        }
        return userGroupVos;
    }
}
