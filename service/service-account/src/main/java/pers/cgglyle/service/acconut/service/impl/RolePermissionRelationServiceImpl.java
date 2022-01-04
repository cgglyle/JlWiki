package pers.cgglyle.service.acconut.service.impl;

import org.springframework.stereotype.Service;
import pers.cgglyle.common.base.service.impl.BaseServiceImpl;
import pers.cgglyle.service.acconut.mapper.RolePermissionRelationMapper;
import pers.cgglyle.service.acconut.model.entity.RolePermissionRelationEntity;
import pers.cgglyle.service.acconut.service.RolePermissionRelationService;

import java.io.Serializable;
import java.util.List;

/**
 * @author cgglyle
 * @date 2021-12-29 14:34
 */
@Service
public class RolePermissionRelationServiceImpl extends BaseServiceImpl<RolePermissionRelationMapper, RolePermissionRelationEntity> implements RolePermissionRelationService {

    @Override
    public List<RolePermissionRelationEntity> getListByRoleId(Serializable id) {
        return lambdaQuery().eq(RolePermissionRelationEntity::getRoleId, id)
                .list();
    }
}
