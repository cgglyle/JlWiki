package pers.cgglyle.service.acconut.filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import pers.cgglyle.service.acconut.service.AccountService;
import pers.cgglyle.service.acconut.util.RoleUtils;

import java.util.Collection;
import java.util.List;

/**
 * @author cgglyle
 * @date 2021-12-30 09:42
 */
public class ResourceSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {
    private static final String ANONYMOUS = "ROLE_ANONYMOUS";

    @Autowired
    private AccountService accountService;

    @Override
    public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
        String requestUrl = ((FilterInvocation) object).getHttpRequest().getRequestURI();
//        for (String url: RELEASE_URL){
//            if (url.equals(requestUrl)){
//                return null;
//            }
//        }
        List<String> roleList = accountService.getRoleList(requestUrl);
        // 如果没有任何权限，就添加一个anonymous的权限
        if (roleList == null) {
            return SecurityConfig.createList(ANONYMOUS);
        }
        List<String> list = RoleUtils.rolePrefix(roleList);
        return SecurityConfig.createList(list.toArray(new String[0]));
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return FilterInvocation.class.isAssignableFrom(clazz);
    }
}
