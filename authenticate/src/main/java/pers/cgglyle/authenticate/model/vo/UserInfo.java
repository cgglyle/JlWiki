package pers.cgglyle.authenticate.model.vo;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import java.io.Serializable;
import java.util.Collection;

/**
 * 登陆显示实体
 *
 * @author cgglyle
 * @date 2021-12-16 17:08
 */
@Data
@AllArgsConstructor
public class UserInfo {

    @Schema(description = "用户id")
    private Serializable id;

    @Schema(description = "用户名")
    private String username;

    @Schema(description = "用户昵称")
    private String userNickName;

    @Schema(description = "用户头像url")
    private String userIcon;

    @Schema(description = "用户角色")
    private Collection<GrantedAuthority> userRole;

    @Schema(description = "Token")
    private String token;
}
