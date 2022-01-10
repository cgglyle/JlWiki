package pers.cgglyle.authenticate.util;

import org.apache.commons.lang3.StringUtils;
import org.springframework.security.core.GrantedAuthority;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * 角色处理工具
 *
 * @author cgglyle
 * @date 2022-01-04 08:48
 */
public class RoleUtils {
    /**
     * 角色前缀
     * <p> 因为Spring Security的缘故所以前缀只能是{@code ROLE_}
     * <p> 当然也有可能不是不能更改的（笑）
     */
    private static final String ROLE_PREFIX = "ROLE_";

    /**
     * 给角色添加前缀并转换成大写
     *
     * @param list 角色列表
     * @return 添加前缀处理后的角色列表
     */
    public static List<String> rolePrefix(List<String> list) {
        List<String> processedRoleList = new ArrayList<>();
        list.forEach(role -> {
            String upperRole = StringUtils.upperCase(role);
            String join = StringUtils.join(ROLE_PREFIX, upperRole);
            processedRoleList.add(join);
        });
        return processedRoleList;
    }

    /**
     * 给角色添加前缀并转换成大写
     *
     * @param collection 角色列表
     * @return 添加前缀处理后的角色列表
     */
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
