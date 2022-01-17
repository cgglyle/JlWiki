package pers.cgglyle.authenticate.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import pers.cgglyle.authenticate.mapper.UserMapper;
import pers.cgglyle.authenticate.model.entity.UserEntity;
import pers.cgglyle.authenticate.service.UserService;
import pers.cgglyle.common.base.service.impl.BaseServiceImpl;
import pers.cgglyle.common.utils.RedisUtils;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 用户服务层实现类
 *
 * @author cgglyle
 * @date 2021/12/6
 */
@Service
public class UserServiceImpl extends BaseServiceImpl<UserMapper, UserEntity> implements UserService {

    @Autowired
    private RedisUtils redisUtils;

    @Override
    public UserEntity getUserEntity(String userName) {
        return query().eq("user_name", userName).one();
    }

    @Override
    public boolean updateUserPassword(Serializable id, String oldPassword, String newPassword) {
        Assert.hasText(oldPassword, "旧密码不能为空");
        Assert.hasText(newPassword, "新密码不能为空");
        Assert.isTrue(oldPassword.equals(newPassword), "新密码不能与老密码相同");
        // 密码验证
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encodeNewPassword = encoder.encode(newPassword);
        boolean matches = encoder.matches(oldPassword, getById(id).getUserPassword());
        Assert.isTrue(matches, "旧密码错误");
        /*
            清理该用户的token盐值
            清理后用户就需要重新登录验证身份
         */
        redisUtils.hdel("SALT", id);
        return lambdaUpdate().eq(UserEntity::getId, id)
                .set(UserEntity::getUserPassword, encodeNewPassword)
                .set(UserEntity::getUserPasswordUpdateTime, LocalDateTime.now())
                .set(UserEntity::getUpdateTime, LocalDateTime.now())
                .update();
    }
}
