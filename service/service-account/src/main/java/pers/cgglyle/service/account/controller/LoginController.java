package pers.cgglyle.service.account.controller;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;
import pers.cgglyle.service.account.annotaion.LoginLog;
import pers.cgglyle.service.account.annotaion.LogoutLog;
import pers.cgglyle.service.account.model.query.LoginQuest;
import pers.cgglyle.service.account.model.vo.UserInfo;
import pers.cgglyle.service.account.service.LoginService;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

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

    private final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }


    /**
     * 登陆系统
     *
     * @param loginQuest 登陆请求模型
     * @return 用户基本信息
     */
    @LoginLog
    @PostMapping("login")
    public UserInfo login(@RequestBody LoginQuest loginQuest) throws NoSuchAlgorithmException, InvalidKeySpecException {
        return loginService.login(loginQuest);
    }

    /**
     * 登出系统
     *
     * @return true-成功, false-失败
     */
    @LogoutLog
    @GetMapping("logout/{id}")
    public boolean logout(@PathVariable String id) {
        return loginService.logout(id);
    }
}
