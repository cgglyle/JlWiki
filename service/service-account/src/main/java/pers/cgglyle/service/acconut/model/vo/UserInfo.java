package pers.cgglyle.service.acconut.model.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import pers.cgglyle.service.acconut.model.vo.UserGroupVo;
import pers.cgglyle.service.acconut.model.vo.UserRoleVo;

import java.io.Serial;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

/**
 * @author cgglyle
 * @date 2021-12-16 17:08
 */
public class UserInfo extends User {

    @Serial
    private static final long serialVersionUID = 3965486146556284604L;

    @ApiModelProperty("用户昵称")
    private String userNickName;

    @ApiModelProperty("用户头像url")
    private String userIcon;

    @ApiModelProperty("用户角色")
    private List<UserRoleVo> userRole;

    @ApiModelProperty("用户组")
    private List<UserGroupVo> userGroup;

    public UserInfo(String username, String password, Collection<? extends GrantedAuthority> authorities, String userNickName, String userIcon) {
        super(username, password, authorities);
        this.userNickName = userNickName;
        this.userIcon = userIcon;
    }

    public UserInfo(String username, String password, boolean enabled, boolean accountNonExpired,
                    boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority>
                            authorities, String userNickName, String userIcon) {
        super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
        this.userNickName = userNickName;
        this.userIcon = userIcon;
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

    public List<UserRoleVo> getUserRole() {
        return userRole;
    }

    public void setUserRole(List<UserRoleVo> userRole) {
        this.userRole = userRole;
    }

    public List<UserGroupVo> getUserGroup() {
        return userGroup;
    }

    public void setUserGroup(List<UserGroupVo> userGroup) {
        this.userGroup = userGroup;
    }
}
