package pers.cgglyle.service.acconut.model.vo;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author cgglyle
 * @date 2021-12-09 13:40
 */
public class UserRoleVo {
    /**
     * UserRoleRelation 主键 ID
     */
    @ApiModelProperty("主键id")
    private Serializable id;
    @ApiModelProperty("角色名")
    private String roleName;

    public UserRoleVo() {
    }

    public UserRoleVo(Integer id, String roleName) {
        this.id = id;
        this.roleName = roleName;
    }

    public Serializable getId() {
        return id;
    }

    public void setId(Serializable id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
