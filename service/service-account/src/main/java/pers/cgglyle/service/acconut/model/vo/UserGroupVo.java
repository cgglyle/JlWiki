package pers.cgglyle.service.acconut.model.vo;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author cgglyle
 * @date 2021-12-13 11:48
 */
public class UserGroupVo {
    /**
     * UserGroupRelation 主键 ID
     */
    @ApiModelProperty("主键id")
    private Integer id;
    @ApiModelProperty("角色名")
    private String groupName;

    public UserGroupVo() {

    }

    public UserGroupVo(Integer id, String groupName) {
        this.id = id;
        this.groupName = groupName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }
}
