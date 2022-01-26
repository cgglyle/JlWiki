package pers.cgglyle.authenticate.service.intf;

import pers.cgglyle.authenticate.model.entity.UserEntity;
import pers.cgglyle.common.base.service.intf.IBaseChangeService;
import pers.cgglyle.common.base.service.intf.IBaseGetService;

import java.io.Serializable;

/**
 * @author cgglyle
 * @date 2022-01-26 18:20
 */
public interface UserChangeService extends IBaseChangeService<UserEntity> {
    /**
     * 更新用户的密码
     *
     * @param id          用户id
     * @param oldPassword 老密码
     * @param newPassword 新密码
     * @return 成功失败
     */
    boolean updateUserPassword(Serializable id, String oldPassword, String newPassword);
}
