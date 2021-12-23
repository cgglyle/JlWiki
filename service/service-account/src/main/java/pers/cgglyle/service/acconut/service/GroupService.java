package pers.cgglyle.service.acconut.service;

import pers.cgglyle.common.base.service.IBaseService;
import pers.cgglyle.service.acconut.model.dto.GroupAddDto;
import pers.cgglyle.service.acconut.model.dto.GroupUpdateDto;
import pers.cgglyle.service.acconut.model.entity.GroupEntity;

/**
 * 用户组服务层接口
 *
 * @author cgglyle
 * @date 2021-12-10 09:58
 */
public interface GroupService extends IBaseService<GroupEntity> {
    /**
     * 创建用户组
     *
     * @param groupAddDto 用户组添加模型
     * @return true-成功，false-失败
     */
    boolean addGroup(GroupAddDto groupAddDto);

    /**
     * 更新角色
     *
     * @param groupUpdateDto 更新用户组模型
     * @return true-成功,false-失败
     */
    boolean updateGroup(GroupUpdateDto groupUpdateDto);
}
