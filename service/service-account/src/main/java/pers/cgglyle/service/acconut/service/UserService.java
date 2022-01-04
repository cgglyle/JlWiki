package pers.cgglyle.service.acconut.service;

import pers.cgglyle.common.base.service.IBaseService;
import pers.cgglyle.service.acconut.model.entity.UserEntity;

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

    boolean updateUserPassword(String id, String oldPassword, String newPassword);
}
