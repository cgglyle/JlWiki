package pers.cgglyle.service.acconut.service;

import pers.cgglyle.common.base.service.IBaseService;
import pers.cgglyle.service.acconut.model.dto.UserRoleRelationDto;
import pers.cgglyle.service.acconut.model.entity.UserRoleRelationEntity;
import pers.cgglyle.service.acconut.model.vo.UserRoleVo;

import java.util.List;

/**
 * 用户角色服务层接口
 *
 * @author cgglyle
 * @date 2021-12-08 16:01
 */
public interface UserRoleRelationService extends IBaseService<UserRoleRelationEntity> {
    /**
     * 获取用户角色列表
     *
     * @param userId 用户id
     * @return 用户角色列表
     */
    List<UserRoleVo> getUserRoleList(Integer userId);

    /**
     * 模糊搜索获取用户id列表
     *
     * @param roleName 角色名字
     * @return 用户id列表
     */
    List<Integer> getUserIdList(String roleName);

    /**
     * 添加用户角色
     *
     * @param userRoleRelationDto 用户添加角色模型
     * @return true-成功,false-失败
     */
    boolean addUserRole(UserRoleRelationDto userRoleRelationDto);
}
