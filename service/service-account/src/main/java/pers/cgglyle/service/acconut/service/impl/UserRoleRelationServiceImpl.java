package pers.cgglyle.service.acconut.service.impl;

import org.springframework.stereotype.Service;
import pers.cgglyle.common.base.service.impl.BaseServiceImpl;
import pers.cgglyle.common.response.ApiException;
import pers.cgglyle.service.acconut.mapper.UserRoleRelationMapper;
import pers.cgglyle.service.acconut.model.entity.UserRoleRelationEntity;
import pers.cgglyle.service.acconut.service.UserRoleRelationService;

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
}
