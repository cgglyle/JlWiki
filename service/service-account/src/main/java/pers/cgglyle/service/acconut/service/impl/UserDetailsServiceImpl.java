package pers.cgglyle.service.acconut.service.impl;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import pers.cgglyle.service.acconut.model.entity.UserEntity;
import pers.cgglyle.service.acconut.model.vo.UserInfo;
import pers.cgglyle.service.acconut.model.vo.UserRoleVo;
import pers.cgglyle.service.acconut.service.UserRoleRelationService;
import pers.cgglyle.service.acconut.service.UserService;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author cgglyle
 * @date 2021-12-16 16:53
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Resource
    private UserService userService;
    @Resource
    private UserRoleRelationService userRoleRelationService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (!StringUtils.hasText(username)) {
            throw new UsernameNotFoundException("无此用户");
        }
        UserEntity userEntity = userService.getUserEntity(username);
        if (userEntity == null) {
            throw new UsernameNotFoundException("无此用户");
        }
        List<UserRoleVo> userRoleList = userRoleRelationService.getUserRoleList(userEntity.getId());
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        userRoleList.forEach(userRoleVo -> {
            GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(userRoleVo.getRoleName());
            grantedAuthorities.add(grantedAuthority);
        });
        return new UserInfo(userEntity.getUserName(), userEntity.getUserPassword(), userEntity.isStatus()
                , true, true, true
                , grantedAuthorities, userEntity.getUserNickName(), userEntity.getUserIcon());
    }
}
