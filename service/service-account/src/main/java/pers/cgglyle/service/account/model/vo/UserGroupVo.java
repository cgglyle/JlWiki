package pers.cgglyle.service.account.model.vo;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * 用户组显示模型
 *
 * @author cgglyle
 * @date 2021-12-13 11:48
 */
public class UserGroupVo {
    /**
     * UserGroupRelation 主键 ID
     */
    @ApiModelProperty("主键id")
    private Serializable id;
    @ApiModelProperty("角色名")
    private String groupName;

    public UserGroupVo() {

    }

    public UserGroupVo(Serializable id, String groupName) {
        this.id = id;
        this.groupName = groupName;
    }

    public Serializable getId() {
        return id;
    }

    public void setId(Serializable id) {
        this.id = id;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }
}
