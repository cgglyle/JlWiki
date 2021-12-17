package pers.cgglyle.service.acconut.service;

import pers.cgglyle.base.service.IBaseService;
import pers.cgglyle.service.acconut.model.dto.UserGroupRelationAddDto;
import pers.cgglyle.service.acconut.model.entity.UserGroupRelationEntity;
import pers.cgglyle.service.acconut.model.vo.UserGroupVo;

import java.util.List;

/**
 * 用户组用户控制服务层接口
 *
 * @author cgglyle
 * @date 2021-12-10 13:36
 */
public interface UserGroupRelationService extends IBaseService<UserGroupRelationEntity> {
    /**
     * 添加用户到用户组
     *
     * @param userGroupRelationAddDto 添加用户组数据模型
     * @return true-成功,false-失败
     */
    boolean addUserGroup(UserGroupRelationAddDto userGroupRelationAddDto);


    /**
     * 获取用户 ID 列表
     *
     * @param userGroup 用户组名称
     * @return 用户ID列表
     */
    List<Integer> getUserIdList(String userGroup);

    /**
     * 获取用户组 ID 和名称
     *
     * @param id 用户 ID
     * @return 用户组显示模型
     */
    List<UserGroupVo> getUserGroupList(Integer id);
}
