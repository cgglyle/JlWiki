package pers.cgglyle.service.acconut.controller;

import io.swagger.annotations.Api;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;
import pers.cgglyle.service.acconut.annotaion.LoginLog;
import pers.cgglyle.service.acconut.model.query.LoginQuest;
import pers.cgglyle.service.acconut.model.vo.UserInfo;
import pers.cgglyle.service.acconut.service.LoginLogService;
import pers.cgglyle.service.acconut.util.SecurityUtils;

/**
 * @author cgglyle
 * @date 2021-12-16 17:32
 */
@Api(tags = "登陆系统")
@CrossOrigin
@RestController
@RequestMapping("/")
public class LoginController {
    private final AuthenticationManager authenticationManager;

    public LoginController(AuthenticationManager authenticationManager){
        this.authenticationManager = authenticationManager;
    }

    @LoginLog
    @PostMapping("login")
    public UserInfo login (@RequestBody LoginQuest loginQuest){
        return SecurityUtils.login(loginQuest.getUserName(), loginQuest.getPassword(), authenticationManager);
    }
}
