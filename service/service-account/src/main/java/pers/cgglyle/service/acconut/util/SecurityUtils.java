package pers.cgglyle.service.acconut.util;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import pers.cgglyle.service.acconut.model.vo.UserInfo;

/**
 * @author cgglyle
 * @date 2021-12-16 17:33
 */
public class SecurityUtils {

    public static UserInfo login(String userName, String password, AuthenticationManager authenticationManager) {
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(userName, password);
        Authentication authentication = authenticationManager.authenticate(token);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        return (UserInfo) authentication.getPrincipal();
    }
}
