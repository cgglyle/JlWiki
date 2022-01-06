package pers.cgglyle.common.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * JWiki配置类
 *
 * @author cgglyle
 * @date 2021-12-31 15:21
 */
@ConfigurationProperties(prefix = "jwiki.security")
public class JWikiSecurityConfig {
    /**
     * 是否开启匿名访问
     * <p> 开启匿名访问后，匿名用户可以访问所有配置了ANONYMOUS权限的API，以及没有配置任何权限的API
     */
    private boolean anonymous;

    public boolean isAnonymous() {
        return anonymous;
    }

    public void setAnonymous(boolean anonymous) {
        this.anonymous = anonymous;
    }
}
