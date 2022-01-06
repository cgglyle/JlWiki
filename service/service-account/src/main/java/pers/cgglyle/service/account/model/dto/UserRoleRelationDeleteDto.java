package pers.cgglyle.service.account.model.dto;

import pers.cgglyle.common.base.model.BaseDeleteDto;

import java.io.Serializable;
import java.util.List;

/**
 * 用户角色关系删除模型
 *
 * @author cgglyle
 * @date 2022-01-04 13:11
 */
public class UserRoleRelationDeleteDto extends BaseDeleteDto {
    public UserRoleRelationDeleteDto() {
    }

    public UserRoleRelationDeleteDto(Serializable id) {
        super(id);
    }

    public UserRoleRelationDeleteDto(List<Serializable> idList) {
        super(idList);
    }
}
