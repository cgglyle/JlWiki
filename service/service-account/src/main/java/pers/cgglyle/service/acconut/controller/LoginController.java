package pers.cgglyle.service.acconut.controller;

import io.swagger.annotations.Api;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;
import pers.cgglyle.service.acconut.annotaion.LoginLog;
import pers.cgglyle.service.acconut.annotaion.LogoutLog;
import pers.cgglyle.service.acconut.model.query.LoginQuest;
import pers.cgglyle.service.acconut.model.vo.UserInfo;
import pers.cgglyle.service.acconut.util.SecurityUtils;

/**
 * 登陆登出注册控制器
 *
 * @author cgglyle
 * @date 2021-12-16 17:32
 */
@Api(tags = "安全系统")
@CrossOrigin
@RestController
@RequestMapping("/")
public class LoginController {
    private final AuthenticationManager authenticationManager;

    public LoginController(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    /**
     * 登陆系统
     *
     * @param loginQuest 登陆请求模型
     * @return 用户基本信息
     */
    @LoginLog
    @PostMapping("login")
    public UserInfo login(@RequestBody LoginQuest loginQuest) {
        return SecurityUtils.login(loginQuest.getUserName(), loginQuest.getPassword(), authenticationManager);
    }

    /**
     * 登出系统
     *
     * @return true-成功, false-失败
     */
    @LogoutLog
    @GetMapping("logout")
    public boolean logout(){
        return true;
    }
}
