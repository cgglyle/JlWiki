package pers.cgglyle.authenticate.service;

import pers.cgglyle.authenticate.model.entity.UserRoleRelationEntity;
import pers.cgglyle.common.base.service.IBaseService;

import java.io.Serializable;

/**
 * 用户角色服务层接口
 *
 * @author cgglyle
 * @date 2021-12-08 16:01
 */
public interface UserRoleRelationService extends IBaseService<UserRoleRelationEntity> {
    /**
     * 删除关系根据角色id
     *
     * @param id 角色id
     * @return 成功失败
     */
    boolean deleteByRoleId(Serializable id);

    /**
     * 删除关系根据用户id
     *
     * @param id 用户id
     * @return 成功失败
     */
    boolean deleteByUserId(Serializable id);
}
