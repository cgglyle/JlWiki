package pers.cgglyle.authenticate.service.impl;

import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import org.springframework.stereotype.Service;
import pers.cgglyle.authenticate.mapper.UserRoleRelationMapper;
import pers.cgglyle.authenticate.model.entity.UserRoleRelationEntity;
import pers.cgglyle.authenticate.service.UserRoleRelationService;
import pers.cgglyle.common.base.service.impl.BaseServiceImpl;
import pers.cgglyle.common.response.ApiException;

import java.io.Serializable;
import java.util.List;

/**
 * 用户角色服务层实现
 *
 * @author cgglyle
 * @date 2021-12-08 16:01
 */
@Service
public class UserRoleRelationServiceImpl extends BaseServiceImpl<UserRoleRelationMapper, UserRoleRelationEntity> implements UserRoleRelationService {

    @Override
    public boolean add(UserRoleRelationEntity entity) {
        List<UserRoleRelationEntity> list = lambdaQuery().eq(UserRoleRelationEntity::getUserId, entity.getUserId()).list();
        list.forEach(userRoleRelationEntity -> {
            if (userRoleRelationEntity.getRoleId().equals(entity.getRoleId())) {
                throw new ApiException("已存在此角色");
            }
        });
        return super.add(entity);
    }

    @Override
    public boolean deleteByRoleId(Serializable id) {
        return deleteUtil(lambdaQuery()
                .eq(UserRoleRelationEntity::getRoleId, id));
    }

    @Override
    public boolean deleteByUserId(Serializable id) {
        return deleteUtil(lambdaQuery()
                .eq(UserRoleRelationEntity::getUserId, id));
    }

    private boolean deleteUtil(LambdaQueryChainWrapper<UserRoleRelationEntity> eq) {
        List<UserRoleRelationEntity> userRoleList = eq.list();
        userRoleList.forEach(userRoleRelationEntity -> {
            boolean delete = delete(userRoleRelationEntity.getId());
            if (!delete) {
                throw new ApiException("删除失败");
            }
        });
        return true;
    }
}
