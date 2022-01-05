package pers.cgglyle.service.acconut.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.LocalVariableTableParameterNameDiscoverer;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import pers.cgglyle.service.acconut.model.dto.UserLoginDto;
import pers.cgglyle.service.acconut.model.entity.LoginLogEntity;
import pers.cgglyle.service.acconut.model.query.LoginQuest;
import pers.cgglyle.service.acconut.model.vo.UserInfo;
import pers.cgglyle.service.acconut.service.LoginLogService;

import java.lang.reflect.Method;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * 登陆日志切面
 *
 * @author cgglyle
 * @date 2021-12-17 10:36
 */
@Aspect
@Component
public class LoginLogAspect {
    private final LoginLogService loginLogService;

    public LoginLogAspect(LoginLogService loginLogService) {
        this.loginLogService = loginLogService;
    }

    /**
     * 登陆日志切入点
     */
    @Pointcut("@annotation(pers.cgglyle.service.acconut.annotaion.LoginLog)")
    public void loginLog() {
    }

    /**
     * 登出日志切入点
     */
    @Pointcut("@annotation(pers.cgglyle.service.acconut.annotaion.LogoutLog)")
    public void logoutLog() {
    }

    /**
     * 日志登陆环绕
     *
     * @param joinPoint 连接点
     * @return 结果
     * @throws Throwable 异常
     */
    @Around("loginLog()")
    public Object doLoginAround(ProceedingJoinPoint joinPoint) throws Throwable {
        LocalDateTime loginTime = LocalDateTime.now();
        LoginLogEntity loginLogEntity = new LoginLogEntity();
        loginLogEntity.setLoginTime(loginTime);
        Object result;
        result = joinPoint.proceed();
        if (SecurityContextHolder.getContext().getAuthentication().getPrincipal() instanceof UserInfo userInfo) {
            loginLogEntity.setLoginUserName(userInfo.getUsername());
        }
        if (SecurityContextHolder.getContext().getAuthentication().getPrincipal() instanceof UserLoginDto userInfo) {
            loginLogEntity.setLoginUserName(userInfo.getUsername());
        }
        loginLogEntity.setStatus(true);
        loginLogService.save(loginLogEntity);
        return result;
    }

    /**
     * 登陆日志异常处理
     *
     * @param joinPoint 连接点
     * @param e 异常信息
     */
    @AfterThrowing(value = "loginLog()", throwing = "e")
    public void doAfterThrowing(JoinPoint joinPoint, Exception e) {
        LocalDateTime loginTime = LocalDateTime.now();
        LoginLogEntity loginLogEntity = new LoginLogEntity();
        // 获得请求参数
        Method method = ((MethodSignature) joinPoint.getSignature()).getMethod();
        // 获得请求名字
        LocalVariableTableParameterNameDiscoverer parameterNameDiscoverer = new LocalVariableTableParameterNameDiscoverer();
        String[] parameterNames = parameterNameDiscoverer.getParameterNames(method);
        Object[] args = joinPoint.getArgs();
        Map<String, Object> params = new HashMap<>();
        for (int i = 0; i < Objects.requireNonNull(parameterNames).length; i++) {
            params.put(parameterNames[i], args[i]);
        }
        loginLogEntity.setLoginUserName(((LoginQuest) params.get("loginQuest")).getUserName());
        loginLogEntity.setLoginTime(loginTime);
        loginLogEntity.setStatus(false);
        loginLogService.save(loginLogEntity);
    }

    /**
     * 登出日志环绕
     *
     * @param joinPoint 连接点
     * @return 结果
     * @throws Throwable 异常
     */
    @Around("logoutLog()")
    public Object doLogoutAround(ProceedingJoinPoint joinPoint) throws Throwable {
        LocalDateTime logoutTime = LocalDateTime.now();
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUserName = authentication.getName();
        loginLogService.lambdaUpdate()
                .eq(LoginLogEntity::getLoginUserName, currentUserName)
                .isNull(LoginLogEntity::getLogoutTime)
                .set(LoginLogEntity::getLogoutTime, logoutTime).update();
        return joinPoint.proceed();
    }
}
