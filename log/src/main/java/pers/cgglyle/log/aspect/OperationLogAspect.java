package pers.cgglyle.log.aspect;

import com.alibaba.fastjson.JSON;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.LocalVariableTableParameterNameDiscoverer;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import pers.cgglyle.log.annotaion.OperationLog;
import pers.cgglyle.log.model.entity.OperationLogEntity;
import pers.cgglyle.log.service.OperationLogService;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * 日志切面处理
 *
 * @author cgglyle
 * @date 2021-12-14 16:21
 */
@Aspect
@Component
public class OperationLogAspect {

    private final OperationLogService operationLogService;

    public OperationLogAspect(OperationLogService operationLogService) {
        this.operationLogService = operationLogService;
    }

    /**
     * 切入点
     */
    @Pointcut("@annotation(pers.cgglyle.log.annotaion.OperationLog)")
    public void log() {

    }


    /**
     * 环绕增强
     *
     * @param joinPoint 切点
     * @return 结果
     * @throws Throwable 未知
     */
    @Around(value = "log()")
    public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable {

        // 创建日志实体
        OperationLogEntity operationLogEntity = new OperationLogEntity();
        // 从切面织入点处通过反射获取织入点的方法
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        // 获取 OperationLog 注解中的值
        OperationLog annotation = signature.getMethod().getAnnotation(OperationLog.class);
        // 获取 OperationLog 注解中的 operationModule 值
        operationLogEntity.setOperationModule(annotation.operationModule());
        operationLogEntity.setRequestMethod(annotation.operationMethod());
        // 获取当前方法的访问地址
        HttpServletRequest request = ((ServletRequestAttributes) Objects
                .requireNonNull(RequestContextHolder.getRequestAttributes()))
                .getRequest();
        operationLogEntity.setRequestAddress(request.getRequestURI());
        // 获取用户姓名
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            Object principal = authentication.getPrincipal();
            if (principal instanceof User user) {
                operationLogEntity.setUserName(user.getUsername());
            }else {
                operationLogEntity.setUserName("非法登陆");
            }
        }
        // 获取请求参数
        Method method = ((MethodSignature) joinPoint.getSignature()).getMethod();
        LocalVariableTableParameterNameDiscoverer parameterNameDiscoverer = new LocalVariableTableParameterNameDiscoverer();
        String[] parameterNames = parameterNameDiscoverer.getParameterNames(method);
        Object[] args = joinPoint.getArgs();
        Map<String, Object> params = new HashMap<>();
        for (int i = 0; i < Objects.requireNonNull(parameterNames).length; i++) {
            params.put(parameterNames[i], args[i]);
        }
        // 请求参数 json 化
        operationLogEntity.setRequestParameter(JSON.toJSONString(params));
        // 请求结果
        Object result;
        // 记录开始时间
        LocalDateTime nowTime = LocalDateTime.now();
        Instant beginTime = Instant.now();
        // 通过代理执行业务逻辑 它之前相当于前置增强（before），它之后相当于后置增强（after）
        result = joinPoint.proceed();
        // 记录结束时间
        operationLogEntity.setQueryEndTime((Duration.between(beginTime, Instant.now())).toMillis());
        //请求结果 json 化
        operationLogEntity.setReturnResult(JSON.toJSONString(result));
        operationLogEntity.setStatus(true);
        operationLogEntity.setCreateTime(nowTime);
        operationLogService.save(operationLogEntity);
        return result;
    }

    @AfterThrowing(value = "log()", throwing = "e")
    public void doAfterThrowing(JoinPoint joinPoint, Exception e) {
        LocalDateTime nowTime = LocalDateTime.now();
        OperationLogEntity operationLogEntity = new OperationLogEntity();
        // 从切面织入点处通过反射获取织入点的方法
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        // 获取 OperationLog 注解中的值
        OperationLog annotation = signature.getMethod().getAnnotation(OperationLog.class);
        // 获取 OperationLog 注解中的 operationModule 值
        operationLogEntity.setOperationModule(annotation.operationModule());
        operationLogEntity.setCreateTime(nowTime);
        // 获取当前方法的访问地址
        HttpServletRequest request = ((ServletRequestAttributes) Objects
                .requireNonNull(RequestContextHolder.getRequestAttributes()))
                .getRequest();
        operationLogEntity.setRequestAddress(request.getRequestURI());
        // 获取用户姓名
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            Object principal = authentication.getPrincipal();
            if (principal instanceof User user) {
                operationLogEntity.setUserName(user.getUsername());
            }
        } else {
            operationLogEntity.setUserName("非法登陆");
        }
        // 获取请求参数
        Method method = ((MethodSignature) joinPoint.getSignature()).getMethod();
        LocalVariableTableParameterNameDiscoverer parameterNameDiscoverer = new LocalVariableTableParameterNameDiscoverer();
        String[] parameterNames = parameterNameDiscoverer.getParameterNames(method);
        Object[] args = joinPoint.getArgs();
        Map<String, Object> params = new HashMap<>();
        for (int i = 0; i < Objects.requireNonNull(parameterNames).length; i++) {
            params.put(parameterNames[i], args[i]);
        }
        // 请求参数 json 化
        operationLogEntity.setRequestParameter(JSON.toJSONString(params));
        operationLogEntity.setReturnResult(e.getMessage());
        operationLogEntity.setStatus(false);
        operationLogEntity.setQueryEndTime(-1L);
        operationLogEntity.setRequestMethod("EXCEPTION");
        operationLogService.save(operationLogEntity);
    }
}
