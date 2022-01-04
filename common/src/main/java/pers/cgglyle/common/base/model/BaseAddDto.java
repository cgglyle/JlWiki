package pers.cgglyle.common.base.model;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author cgglyle
 * @date 2022-01-04 09:51
 */
public class BaseAddDto extends BaseDto {
    @ApiModelProperty("创建者")
    private Integer createUser;

    public Integer getCreateUser() {
        return createUser;
    }

    public void setCreateUser(Integer createUser) {
        this.createUser = createUser;
    }
}
