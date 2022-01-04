package pers.cgglyle.service.acconut.model.dto;

import pers.cgglyle.common.base.model.BaseDeleteDto;

import java.io.Serializable;
import java.util.List;

/**
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
