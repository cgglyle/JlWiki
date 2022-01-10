package pers.cgglyle.authenticate.service.impl;

import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import org.springframework.stereotype.Service;
import pers.cgglyle.common.base.service.impl.BaseServiceImpl;
import pers.cgglyle.common.response.ApiException;
import pers.cgglyle.authenticate.mapper.RolePermissionRelationMapper;
import pers.cgglyle.authenticate.model.entity.RolePermissionRelationEntity;
import pers.cgglyle.authenticate.service.RolePermissionRelationService;

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

    @Override
    public boolean deleteByRoleId(Serializable id) {
        return deleteUtil(lambdaQuery()
                .eq(RolePermissionRelationEntity::getRoleId, id));
    }

    @Override
    public boolean deleteByPermissionId(Serializable id) {
        return deleteUtil(lambdaQuery()
                .eq(RolePermissionRelationEntity::getPermissionId, id));
    }

    private boolean deleteUtil(LambdaQueryChainWrapper<RolePermissionRelationEntity> eq) {
        List<RolePermissionRelationEntity> rolePermissionList = eq.list();
        rolePermissionList.forEach(rolePermissionRelationEntity -> {
            boolean delete = delete(rolePermissionRelationEntity.getId());
            if (!delete) {
                throw new ApiException("删除失败");
            }
        });
        return true;
    }
}
