package pers.cgglyle.authenticate.model.dto;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.io.Serial;
import java.util.Collection;

/**
 * 登陆数据模型
 *
 * @author cgglyle
 * @date 2021-12-27 10:10
 */
@Getter
@Setter
public class UserLoginDto extends User {
    @Serial
    private static final long serialVersionUID = 3965486146556284604L;

    @Schema(description = "用户id")
    private Integer id;

    @Schema(description = "用户昵称")
    private String userNickName;

    @Schema(description = "用户头像url")
    private String userIcon;

    private String token;

    public UserLoginDto(Integer id, String username, String password, Collection<? extends GrantedAuthority> authorities, String userNickName, String userIcon, String token) {
        super(username, password, authorities);
        this.id = id;
        this.userNickName = userNickName;
        this.userIcon = userIcon;
        this.token = token;
    }

    public UserLoginDto(Integer id, String username, String password, boolean enabled, boolean accountNonExpired,
                        boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority>
                                authorities, String userNickName, String userIcon) {
        super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
        this.id = id;
        this.userNickName = userNickName;
        this.userIcon = userIcon;
    }
}
