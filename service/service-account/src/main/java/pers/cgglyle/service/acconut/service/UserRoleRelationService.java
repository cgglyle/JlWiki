package pers.cgglyle.service.acconut.service;

import pers.cgglyle.common.base.service.IBaseService;
import pers.cgglyle.service.acconut.model.entity.UserRoleRelationEntity;

import java.io.Serializable;

/**
 * 用户角色服务层接口
 *
 * @author cgglyle
 * @date 2021-12-08 16:01
 */
public interface UserRoleRelationService extends IBaseService<UserRoleRelationEntity> {
    boolean deleteByRoleId(Serializable id);
    boolean deleteByUserId(Serializable id);
}
