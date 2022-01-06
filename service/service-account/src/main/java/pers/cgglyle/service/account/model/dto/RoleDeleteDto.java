package pers.cgglyle.service.account.model.dto;

import pers.cgglyle.common.base.model.BaseDeleteDto;

import java.io.Serializable;
import java.util.List;

/**
 * 角色删除模型
 *
 * @author cgglyle
 * @date 2022-01-04 10:12
 */
public class RoleDeleteDto extends BaseDeleteDto {
    public RoleDeleteDto() {
    }

    public RoleDeleteDto(Serializable id) {
        super(id);
    }

    public RoleDeleteDto(List<Serializable> idList) {
        super(idList);
    }
}
