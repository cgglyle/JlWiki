package pers.cgglyle.service.acconut.service;

import pers.cgglyle.base.service.IBaseService;
import pers.cgglyle.service.acconut.model.dto.UserAddDto;
import pers.cgglyle.service.acconut.model.dto.UserUpdateDto;
import pers.cgglyle.service.acconut.model.entity.UserEntity;

/**
 * 用户服务层接口
 *
 * @author cgglyle
 * @date 2021/12/6
 */
public interface UserService extends IBaseService<UserEntity> {
    /**
     * 添加用户
     *
     * @param userAddDto 用户添加数据
     * @return true-成功,false-失败
     */
    boolean addUser(UserAddDto userAddDto);

    /**
     * 更新用户
     *
     * @param userUpdateDto 更新用户数据
     * @return true-成功,false-失败
     */
    boolean updateUser(UserUpdateDto userUpdateDto);
}
