package pers.cgglyle.service.acconut.model.vo;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author cgglyle
 * @date 2021-12-09 13:40
 */
public class UserRoleVo {
    @ApiModelProperty("主键id")
    private Integer id;
    @ApiModelProperty("角色名")
    private String roleName;

    public UserRoleVo(Integer id, String roleName) {
        this.id = id;
        this.roleName = roleName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
