package pers.cgglyle.authenticate.service.intf;

import pers.cgglyle.authenticate.model.entity.UserEntity;
import pers.cgglyle.common.base.service.intf.IBaseGetService;

/**
 * @author cgglyle
 * @date 2022-01-25 15:39
 */
public interface UserGetService extends IBaseGetService<UserEntity> {
    /**
     * 精确查询用户名
     *
     * @param userName 用户名
     * @return 用户数据实体
     */
    UserEntity getUserEntity(String userName);
}
