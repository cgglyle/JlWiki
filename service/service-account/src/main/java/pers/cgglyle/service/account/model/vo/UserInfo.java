package pers.cgglyle.service.account.model.vo;

import io.swagger.annotations.ApiModelProperty;
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
}
