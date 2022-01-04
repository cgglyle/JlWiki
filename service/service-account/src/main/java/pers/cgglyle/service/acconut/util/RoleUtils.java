package pers.cgglyle.service.acconut.util;

import org.apache.commons.lang3.StringUtils;
import org.springframework.security.core.GrantedAuthority;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author cgglyle
 * @date 2022-01-04 08:48
 */
public class RoleUtils {
    private static final String ROLE_PREFIX = "ROLE_";

    public static List<String> rolePrefix(List<String> list) {
        List<String> processedRoleList = new ArrayList<>();
        list.forEach(role -> {
            String upperRole = StringUtils.upperCase(role);
            String join = StringUtils.join(ROLE_PREFIX, upperRole);
            processedRoleList.add(join);
        });
        return processedRoleList;
    }

    public static List<String> rolePrefix(Collection<GrantedAuthority> collection) {
        List<String> processedRoleList = new ArrayList<>();
        collection.forEach(grantedAuthority -> {
            String upperCases = StringUtils.upperCase(grantedAuthority.getAuthority());
            String join = StringUtils.join(ROLE_PREFIX, upperCases);
            processedRoleList.add(join);
        });
        return processedRoleList;
    }
}
