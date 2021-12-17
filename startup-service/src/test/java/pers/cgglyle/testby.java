package pers.cgglyle;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author cgglyle
 * @date 2021-12-17 09:40
 */
@SpringBootTest
public class testby {
    @Test
    public void ss() {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        System.out.println(bCryptPasswordEncoder.encode("11111111"));
    }
}
