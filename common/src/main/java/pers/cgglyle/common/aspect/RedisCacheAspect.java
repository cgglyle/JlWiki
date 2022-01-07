package pers.cgglyle.common.aspect;

import com.alibaba.fastjson.JSON;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import pers.cgglyle.common.annotaion.RedisCache;
import pers.cgglyle.common.utils.RedisUtils;

/**
 * Redis 缓存切面
 * <p> 通过此切面进行缓存
 *
 * @author cgglyle
 * @date 2021-12-23 11:53
 */
@Aspect
@Component
public class RedisCacheAspect {
    private final RedisUtils redisUtils;

    public RedisCacheAspect(RedisUtils redisUtils) {
        this.redisUtils = redisUtils;
    }

    @Pointcut("@annotation(pers.cgglyle.common.annotaion.RedisCache)")
    public void redisCache() {

    }

    /**
     * 环绕缓存添加
     */
    @Around("redisCache()")
    public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable {
        // 生成缓存key 返回类型+方法名+参数哈希
        String cacheKey = new StringBuilder().append(joinPoint.getTarget().getClass().getName())
                .append(".")
                .append(joinPoint.getSignature().getName())
                .append(JSON.toJSONString(joinPoint.getArgs()).hashCode())
                .toString();
        if (redisUtils.hasKey(cacheKey)) {
            return redisUtils.get(cacheKey);
        }
        Object result = joinPoint.proceed();
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        // 获取 OperationLog 注解中的值
        RedisCache annotation = signature.getMethod().getAnnotation(RedisCache.class);
        redisUtils.set(cacheKey, result, annotation.timeout());
        return result;
    }
}
