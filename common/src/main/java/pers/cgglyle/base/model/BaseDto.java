package pers.cgglyle.base.model;

import io.swagger.annotations.ApiModelProperty;

import java.util.Objects;

/**
 * 基础数据模型
 *
 * @author cgglyle
 * @date 2021/12/7
 */
public class BaseDto {

    @ApiModelProperty("创建者")
    private Integer createUser;

    public Integer getCreateUser() {
        return createUser;
    }

    public void setCreateUser(Integer createUser) {
        this.createUser = createUser;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BaseDto baseDto = (BaseDto) o;
        return Objects.equals(createUser, baseDto.createUser);
    }

    @Override
    public int hashCode() {
        return Objects.hash(createUser);
    }
}
