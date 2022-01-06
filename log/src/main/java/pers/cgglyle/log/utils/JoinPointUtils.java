package pers.cgglyle.log.utils;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.LocalVariableTableParameterNameDiscoverer;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * 切面连接点处理工具
 *
 * @author cgglyle
 * @date 2022-01-05 08:47
 */
public class JoinPointUtils {

    /**
     * 根据连接点获取入参
     *
     * @param joinPoint 连接点
     * @return Map类型的入参
     */
    public static Map<String, Object> getMethod(JoinPoint joinPoint) {
        Method method = ((MethodSignature) joinPoint.getSignature()).getMethod();
        LocalVariableTableParameterNameDiscoverer parameterNameDiscoverer = new LocalVariableTableParameterNameDiscoverer();
        String[] parameterNames = parameterNameDiscoverer.getParameterNames(method);
        Object[] args = joinPoint.getArgs();
        Map<String, Object> params = new HashMap<>(8);
        for (int i = 0; i < Objects.requireNonNull(parameterNames).length; i++) {
            params.put(parameterNames[i], args[i]);
        }
        return params;
    }
}
