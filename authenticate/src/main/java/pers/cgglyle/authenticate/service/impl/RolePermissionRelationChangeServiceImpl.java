package pers.cgglyle.authenticate.service.impl;

import org.springframework.stereotype.Service;
import pers.cgglyle.authenticate.mapper.RolePermissionRelationMapper;
import pers.cgglyle.authenticate.model.entity.RolePermissionRelationEntity;
import pers.cgglyle.authenticate.service.intf.RolePermissionRelationChangeService;
import pers.cgglyle.common.base.service.impl.BaseChangeServiceImpl;

/**
 * @author cgglyle
 * @date 2022-01-27 11:42
 */
@Service
public class RolePermissionRelationChangeServiceImpl extends BaseChangeServiceImpl<RolePermissionRelationMapper, RolePermissionRelationEntity> implements RolePermissionRelationChangeService {
}
