package pers.cgglyle.common.util.config;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;

import java.time.Duration;

/**
 * Redis配置类
 *
 * @author cgglyle
 * @date 2021-12-09 16:21
 */
@EnableCaching
@Configuration
public class RedisConfig {

    @Bean
    public RedisCacheConfiguration cacheConfiguration() {
        // 设置缓存过期时间为 120 秒后
        return RedisCacheConfiguration.defaultCacheConfig().entryTtl(Duration.ofSeconds(120)).disableCachingNullValues();
    }

    @Bean
    public RedisCacheManager cacheManager(RedisConnectionFactory factory) {
        // 使用 RedisCacheManager 作为缓存管理器
        return RedisCacheManager.builder(factory).cacheDefaults(cacheConfiguration()).transactionAware().build();
    }

    @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
        // Jackson 序列方式
        Jackson2JsonRedisSerializer<Object> jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer<>(Object.class);
        ObjectMapper om = new ObjectMapper();
        // Jackson 默认自动识别 Public 修饰的成员变量、getter、setter
        // private、protected、public 修饰的成员变量都可以自动识别，无需都指定 getter、setter 或者 public。
        // 参考 https://blog.csdn.net/sdyy321/article/details/40298081
        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        // 对于 8 种基本数据类型及其封装类和 String ，其他的类型在序列化的时候带上该类型和值
        // 参考 https://www.jianshu.com/p/c5fcd2a1ab49
        om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        jackson2JsonRedisSerializer.setObjectMapper(om);
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        // Redis 链接
        template.setConnectionFactory(redisConnectionFactory);
        // Redis Key - Value 序列化使用 Jackson
        template.setKeySerializer(jackson2JsonRedisSerializer);
        template.setValueSerializer(jackson2JsonRedisSerializer);
        // Redis HashKey - HashValue 序列化使用 Jackson
        template.setHashKeySerializer(jackson2JsonRedisSerializer);
        template.setHashValueSerializer(jackson2JsonRedisSerializer);
        template.afterPropertiesSet();
        return template;
    }

    @Bean
    @ConditionalOnMissingBean(StringRedisTemplate.class)
    public StringRedisTemplate stringRedisTemplate(
            RedisConnectionFactory redisConnectionFactory) {
        StringRedisTemplate template = new StringRedisTemplate();
        template.setConnectionFactory(redisConnectionFactory);
        return template;
    }
}

