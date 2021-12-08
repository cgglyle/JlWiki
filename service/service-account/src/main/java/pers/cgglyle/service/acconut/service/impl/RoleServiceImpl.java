package pers.cgglyle.service.acconut.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import pers.cgglyle.base.model.BaseQuery;
import pers.cgglyle.base.service.impl.BaseServiceImpl;
import pers.cgglyle.response.PageResult;
import pers.cgglyle.service.acconut.mapper.RoleMapper;
import pers.cgglyle.service.acconut.model.dto.RoleAddDto;
import pers.cgglyle.service.acconut.model.dto.RoleUpdateDto;
import pers.cgglyle.service.acconut.model.entity.RoleEntity;
import pers.cgglyle.service.acconut.model.query.RoleQuery;
import pers.cgglyle.service.acconut.model.vo.RoleVo;
import pers.cgglyle.service.acconut.service.RoleService;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 角色服务层
 *
 * @author cgglyle
 * @date 2021-12-08 13:08
 */
@Service
public class RoleServiceImpl extends BaseServiceImpl<RoleMapper, RoleEntity> implements RoleService {
    @Override
    public PageResult getPage(BaseQuery baseQuery) {
        RoleQuery roleQuery = (RoleQuery) baseQuery;
        QueryWrapper<RoleEntity> queryWrapper = new QueryWrapper<>();
        if (roleQuery.getRoleName() != null) {
            queryWrapper.like("role_name", roleQuery.getRoleName());
        }
        if (roleQuery.getRoleDescription() != null) {
            queryWrapper.like("role_description", roleQuery.getRoleDescription());
        }
        queryWrapper.eq("is_deleted", true);
        queryWrapper.orderByDesc("id");
        Page<RoleEntity> page = new Page<>(roleQuery.getPageNum(), roleQuery.getPageSize());
        Page<RoleEntity> data = baseMapper.selectPage(page, queryWrapper);
        List<RoleVo> collect = data.getRecords().stream().map(role -> {
            RoleVo roleVo = new RoleVo();
            BeanUtils.copyProperties(role, roleVo);
            return roleVo;
        }).collect(Collectors.toList());
        return new PageResult(roleQuery.getPageNum(), roleQuery.getPageSize(), data.getTotal(), data.getPages(), collect);
    }

    @Override
    public boolean addRole(RoleAddDto roleAddDto) {
        RoleEntity roleEntity = new RoleEntity();
        BeanUtils.copyProperties(roleAddDto, roleEntity);
        return this.add(roleEntity);
    }

    @Override
    public boolean updateRole(RoleUpdateDto roleUpdateDto) {
        RoleEntity roleEntity = new RoleEntity();
        BeanUtils.copyProperties(roleUpdateDto, roleEntity);
        return this.update(roleEntity);
    }
}
