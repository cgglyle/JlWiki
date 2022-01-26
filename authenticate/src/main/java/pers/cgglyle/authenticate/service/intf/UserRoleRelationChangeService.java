package pers.cgglyle.authenticate.service.intf;

import pers.cgglyle.authenticate.model.entity.UserRoleRelationEntity;
import pers.cgglyle.common.base.service.intf.IBaseChangeService;
import pers.cgglyle.common.base.service.intf.IBaseService;

import java.io.Serializable;

/**
 * @author cgglyle
 * @date 2022-01-26 19:48
 */
public interface UserRoleRelationChangeService extends IBaseChangeService<UserRoleRelationEntity> {
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
