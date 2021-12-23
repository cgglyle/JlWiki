package pers.cgglyle;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import pers.cgglyle.common.util.redis.RedisUtils;

/**
 * @author cgglyle
 * @date 2021-12-17 09:40
 */
@SpringBootTest
public class testby {
    @Autowired
    StringRedisTemplate redisTemplate;
    @Autowired
    RedisTemplate<String, Object> template;
    @Autowired
    RedisUtils redisUtils;
    @Test
    public void ss() {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        System.out.println(bCryptPasswordEncoder.encode("11111111"));
    }
    @Test
    public void redis(){
        redisTemplate.opsForValue().set("1","ss");
    }
}
