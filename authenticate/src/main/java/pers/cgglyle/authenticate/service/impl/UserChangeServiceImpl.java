package pers.cgglyle.authenticate.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import pers.cgglyle.authenticate.mapper.UserMapper;
import pers.cgglyle.authenticate.model.entity.UserEntity;
import pers.cgglyle.authenticate.service.intf.UserChangeService;
import pers.cgglyle.authenticate.service.intf.UserGetService;
import pers.cgglyle.common.base.service.impl.BaseChangeServiceImpl;
import pers.cgglyle.common.utils.RedisUtils;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author cgglyle
 * @date 2022-01-26 18:22
 */
@Service
public class UserChangeServiceImpl extends BaseChangeServiceImpl<UserMapper, UserEntity> implements UserChangeService {
    @Autowired
    private UserGetService userGetService;
    @Autowired
    private RedisUtils redisUtils;

    /**
     * 更新用户的密码
     *
     * @param id          用户id
     * @param oldPassword 老密码
     * @param newPassword 新密码
     * @return 成功失败
     */
    @Override
    public boolean updateUserPassword(Serializable id, String oldPassword, String newPassword) {
        Assert.hasText(oldPassword, "旧密码不能为空");
        Assert.hasText(newPassword, "新密码不能为空");
        Assert.isTrue(oldPassword.equals(newPassword), "新密码不能与老密码相同");
        // 密码验证
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encodeNewPassword = encoder.encode(newPassword);
        boolean matches = encoder.matches(oldPassword, this.userGetService.getById(id).getUserPassword());
        Assert.isTrue(matches, "旧密码错误");
        /*
            清理该用户的token盐值
            清理后用户就需要重新登录验证身份
         */
        this.redisUtils.hdel("SALT", id);
        return super.lambdaUpdate().eq(UserEntity::getId, id)
                .set(UserEntity::getUserPassword, encodeNewPassword)
                .set(UserEntity::getUserPasswordUpdateTime, LocalDateTime.now())
                .set(UserEntity::getUpdateTime, LocalDateTime.now())
                .update();
    }
}
