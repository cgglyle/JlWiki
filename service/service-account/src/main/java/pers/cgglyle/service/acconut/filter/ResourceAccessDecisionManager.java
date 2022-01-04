package pers.cgglyle.service.acconut.filter;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.FilterInvocation;
import pers.cgglyle.common.config.JWikiSecurityConfig;

import java.util.Collection;

/**
 * 权限判决器
 *
 * @author cgglyle
 * @date 2021-12-31 13:08
 */
public class ResourceAccessDecisionManager implements AccessDecisionManager {
    private static final String ANONYMOUS = "ROLE_ANONYMOUS";
    @Autowired
    private JWikiSecurityConfig jWikiSecurityConfig;

    /**
     * 权限判决器
     * <p>
     * 判断用户是否有url所有想要的权限
     * <p>
     * 如果开启允许匿名用户访问的话，就
     *
     * @param authentication   用户权限载体
     * @param object           未知
     * @param configAttributes url权限载体
     */
    @Override
    public void decide(Authentication authentication, Object object, Collection<ConfigAttribute> configAttributes) throws AccessDeniedException, InsufficientAuthenticationException {
        // 是否允许匿名用户访问
        if (jWikiSecurityConfig.isAnonymous()) {
            return;
        }
        // 获取用户权限
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        // 判断用户是否有url需要的权限
        for (ConfigAttribute configAttribute : configAttributes) {
            String attribute = configAttribute.getAttribute();
            // 如果url的要求权限是匿名用户，或者是空，就直接放行
            if (StringUtils.equals(attribute, ANONYMOUS) || !StringUtils.isNotBlank(attribute)) {
                return;
            }
            for (GrantedAuthority grantedAuthority : authorities) {
                if (StringUtils.equals(grantedAuthority.getAuthority(), attribute)) {
                    return;
                }
            }
        }
        throw new AccessDeniedException("无权访问");
    }

    @Override
    public boolean supports(ConfigAttribute attribute) {
        return false;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return FilterInvocation.class.isAssignableFrom(clazz);
    }
}
