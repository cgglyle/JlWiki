package pers.cgglyle.common.base.model;

import java.io.Serializable;
import java.util.List;

/**
 * @author cgglyle
 * @date 2022-01-04 10:11
 */
public class BaseDeleteDto extends BaseDto {
    private Serializable id;
    private List<Serializable> idList;

    public BaseDeleteDto() {
    }

    public BaseDeleteDto(Serializable id) {
        this.id = id;
    }

    public BaseDeleteDto(List<Serializable> idList) {
        this.idList = idList;
    }

    public Serializable getId() {
        return id;
    }

    public void setId(Serializable id) {
        this.id = id;
    }

    public List<Serializable> getIdList() {
        return idList;
    }

    public void setIdList(List<Serializable> idList) {
        this.idList = idList;
    }
}
