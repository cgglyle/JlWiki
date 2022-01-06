package pers.cgglyle.service.account.service;

import pers.cgglyle.common.base.service.IBaseRelationService;
import pers.cgglyle.service.account.model.entity.UserEntity;
import pers.cgglyle.service.account.model.vo.UserRoleVo;

import java.io.Serializable;
import java.util.List;

/**
 * @author cgglyle
 * @date 2022-01-04 11:26
 */
public interface AccountService extends IBaseRelationService {
    /**
     * 获取用户角色列表
     *
     * @param id 用户id
     * @return 用户角色列表
     */
    List<UserRoleVo> getUserRoleList(Serializable id);

    /**
     * 获取角色列表
     *
     * @param url 请求url
     * @return 角色
     */
    List<String> getRoleList(String url);

    /**
     * 更新用户密码
     *
     * @param id          用户id
     * @param oldPassword 老密码
     * @param newPassword 新密码
     * @return 成功失败
     */
    boolean updateUserPassword(Serializable id, String oldPassword, String newPassword);

    /**
     * 精确查询用户名
     *
     * @param userName 用户名
     * @return 用户数据实体
     */
    UserEntity getUserEntity(String userName);
}
