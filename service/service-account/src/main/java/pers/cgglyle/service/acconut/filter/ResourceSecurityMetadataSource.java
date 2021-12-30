package pers.cgglyle.service.acconut.filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import pers.cgglyle.service.acconut.model.dto.PermissionGetListDto;
import pers.cgglyle.service.acconut.service.PermissionService;

import java.util.Collection;
import java.util.List;

/**
 * @author cgglyle
 * @date 2021-12-30 09:42
 */
public class ResourceSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {

    @Autowired
    private PermissionService permissionService;

    @Override
    public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
        String requestUrl = ((FilterInvocation) object).getHttpRequest().getRequestURI();
        List<PermissionGetListDto> permissionList = permissionService.getPermissionList(requestUrl);
        if (permissionList.isEmpty()){
            return null;
        }
        return SecurityConfig.createList(permissionList.toArray(new String[0]));
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }
}
