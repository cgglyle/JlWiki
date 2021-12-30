package pers.cgglyle.service.acconut.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pers.cgglyle.common.base.service.impl.BaseServiceImpl;
import pers.cgglyle.service.acconut.mapper.RolePermissionRelationMapper;
import pers.cgglyle.service.acconut.model.dto.RolePermissionRelationDto;
import pers.cgglyle.service.acconut.model.entity.PermissionEntity;
import pers.cgglyle.service.acconut.model.entity.RolePermissionRelationEntity;
import pers.cgglyle.service.acconut.model.vo.RolePermissionRelationVo;
import pers.cgglyle.service.acconut.service.PermissionService;
import pers.cgglyle.service.acconut.service.RolePermissionRelationService;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author cgglyle
 * @date 2021-12-29 14:34
 */
@Service
public class RolePermissionRelationServiceImpl extends BaseServiceImpl<RolePermissionRelationMapper, RolePermissionRelationEntity> implements RolePermissionRelationService {

    @Autowired
    private PermissionService permissionService;

    @Override
    public boolean add(RolePermissionRelationDto rolePermissionRelationDto) {
        RolePermissionRelationEntity rolePermissionRelationEntity = new RolePermissionRelationEntity();
        BeanUtils.copyProperties(rolePermissionRelationDto,rolePermissionRelationEntity);
        return super.add(rolePermissionRelationEntity);
    }

    @Override
    public List<RolePermissionRelationVo> getPermissionList(Integer roleId) {
        List<RolePermissionRelationEntity> permissionList = lambdaQuery()
                .eq(RolePermissionRelationEntity::getRoleId,roleId)
                .list();
        return permissionList.stream().map(permission -> {
            RolePermissionRelationVo rolePermissionRelationVo = new RolePermissionRelationVo();
            PermissionEntity permissionEntity = permissionService.getById(permission.getPermissionId());
            rolePermissionRelationVo.setPermission(permissionEntity.getPermissionName());
            BeanUtils.copyProperties(permission, rolePermissionRelationVo);
            return rolePermissionRelationVo;
        }).collect(Collectors.toList());
    }
}
