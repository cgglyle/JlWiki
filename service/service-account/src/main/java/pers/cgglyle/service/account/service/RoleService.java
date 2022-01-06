package pers.cgglyle.service.account.service;

import pers.cgglyle.common.base.service.IBaseService;
import pers.cgglyle.service.account.model.dto.RoleUpdateDto;
import pers.cgglyle.service.account.model.entity.RoleEntity;

/**
 * 角色服务层接口
 *
 * @author cgglyle
 * @date 2021-12-08 13:08
 */
public interface RoleService extends IBaseService<RoleEntity> {

    /**
     * 更新角色
     *
     * @param roleUpdateDto 更新角色模型
     * @return true-成功,false-失败
     */
    boolean updateRole(RoleUpdateDto roleUpdateDto);
}
