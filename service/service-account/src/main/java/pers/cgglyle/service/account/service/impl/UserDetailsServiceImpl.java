package pers.cgglyle.service.account.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import pers.cgglyle.service.account.model.dto.UserLoginDto;
import pers.cgglyle.service.account.model.entity.UserEntity;
import pers.cgglyle.service.account.model.vo.UserRoleVo;
import pers.cgglyle.service.account.service.AccountService;

import java.util.ArrayList;
import java.util.List;

/**
 * 账号验证方式
 *
 * @author cgglyle
 * @date 2021-12-16 16:53
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private AccountService accountService;

    /**
     * 根据用户名创建UserDetails
     *
     * @param username 用户名
     * @return UserDetails类
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 判断用户名是否为空
        if (!StringUtils.hasText(username)) {
            throw new UsernameNotFoundException("用户名为空");
        }
        UserEntity userEntity = accountService.getUserEntity(username);
        // 判断是否有此用户
        if (userEntity == null) {
            throw new UsernameNotFoundException("无此用户");
        }
        // 获取用户角色信息
        List<UserRoleVo> userRoleList = accountService.getUserRoleList(userEntity.getId());
        // 创建GrantedAuthority角色载体
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        // 将用户角色放入载体
        userRoleList.forEach(userRoleVo -> {
            GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(userRoleVo.getRoleName());
            grantedAuthorities.add(grantedAuthority);
        });
        return new UserLoginDto(userEntity.getId(), userEntity.getUserName(), userEntity.getUserPassword(), userEntity.isStatus()
                , true, true, true
                , grantedAuthorities, userEntity.getUserNickName(), userEntity.getUserIcon());
    }
}
