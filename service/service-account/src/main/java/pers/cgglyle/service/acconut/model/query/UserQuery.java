package pers.cgglyle.service.acconut.model.query;

import io.swagger.annotations.ApiModelProperty;
import pers.cgglyle.base.model.BaseQuery;

/**
 * 用户查询体
 *
 * @author cgglyle
 * @date 2021/12/6
 */
public class UserQuery extends BaseQuery {
    @ApiModelProperty("账户名")
    private String userName;
    @ApiModelProperty("电话")
    private String phone;
    @ApiModelProperty("昵称")
    private String userNickName;
    @ApiModelProperty("邮箱")
    private String userEmail;
    @ApiModelProperty("性别")
    private String gender;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUserNickName() {
        return userNickName;
    }

    public void setUserNickName(String userNickName) {
        this.userNickName = userNickName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}