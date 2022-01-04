package pers.cgglyle.service.acconut.model.dto;

import pers.cgglyle.common.base.model.BaseDeleteDto;

import java.io.Serializable;
import java.util.List;

/**
 * @author cgglyle
 * @date 2022-01-04 13:08
 */
public class UserDeleteDto extends BaseDeleteDto {
    public UserDeleteDto() {
    }

    public UserDeleteDto(Serializable id) {
        super(id);
    }

    public UserDeleteDto(List<Serializable> idList) {
        super(idList);
    }
}
