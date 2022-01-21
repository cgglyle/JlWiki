package pers.cgglyle.authenticate.filter;

import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import pers.cgglyle.authenticate.constant.enums.AccountEnum;
import pers.cgglyle.authenticate.service.intf.AccountService;
import pers.cgglyle.authenticate.util.RoleUtils;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.List;

/**
 * @author cgglyle
 * @date 2021-12-30 09:42
 */
public class ResourceSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {
    @Resource
    private AccountService accountService;

    /**
     * 从数据库中提取API所需权限
     * <P> 如果URL没有配置权限，则默认赋予一个「ANONYMOUS」权限
     *
     * @param object 请求
     * @return 权限列表
     * @throws IllegalArgumentException 异常
     */
    @Override
    public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
        String requestUrl = ((FilterInvocation) object).getHttpRequest().getRequestURI();
        List<String> roleList = accountService.getRoleList(requestUrl);
        // 如果没有任何权限，就添加一个anonymous的权限
        if (roleList == null) {
            return SecurityConfig.createList(AccountEnum.ANONYMOUS.getMessage());
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
