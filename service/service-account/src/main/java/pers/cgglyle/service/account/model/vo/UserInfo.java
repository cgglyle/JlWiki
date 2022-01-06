package pers.cgglyle.service.account.model.vo;

import io.swagger.annotations.ApiModelProperty;
import org.springframework.security.core.GrantedAuthority;

import java.io.Serializable;
import java.util.Collection;

/**
 * 登陆显示实体
 *
 * @author cgglyle
 * @date 2021-12-16 17:08
 */
public class UserInfo {

    @ApiModelProperty("用户id")
    private Serializable id;

    @ApiModelProperty("用户名")
    private String username;

    @ApiModelProperty("用户昵称")
    private String userNickName;

    @ApiModelProperty("用户头像url")
    private String userIcon;

    @ApiModelProperty("用户角色")
    private Collection<GrantedAuthority> userRole;

    @ApiModelProperty("Token")
    private String token;

    public UserInfo() {

    }

    public UserInfo(Serializable id, String username, String userNickName, String userIcon, Collection<GrantedAuthority> userRole, String token) {
        this.id = id;
        this.username = username;
        this.userNickName = userNickName;
        this.userIcon = userIcon;
        this.userRole = userRole;
        this.token = token;
    }

    public Serializable getId() {
        return id;
    }

    public void setId(Serializable id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserNickName() {
        return userNickName;
    }

    public void setUserNickName(String userNickName) {
        this.userNickName = userNickName;
    }

    public String getUserIcon() {
        return userIcon;
    }

    public void setUserIcon(String userIcon) {
        this.userIcon = userIcon;
    }

    public Collection<GrantedAuthority> getUserRole() {
        return userRole;
    }

    public void setUserRole(Collection<GrantedAuthority> userRole) {
        this.userRole = userRole;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
