package pers.cgglyle.authenticate.service;

import pers.cgglyle.authenticate.model.entity.UserEntity;
import pers.cgglyle.common.base.service.IBaseService;

import java.io.Serializable;

/**
 * 用户服务层接口
 *
 * @author cgglyle
 * @date 2021/12/6
 */
public interface UserService extends IBaseService<UserEntity> {

    /**
     * 精确查询用户名
     *
     * @param userName 用户名
     * @return 用户数据实体
     */
    UserEntity getUserEntity(String userName);

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
