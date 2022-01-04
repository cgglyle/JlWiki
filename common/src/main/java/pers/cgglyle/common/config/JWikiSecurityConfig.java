package pers.cgglyle.common.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author cgglyle
 * @date 2021-12-31 15:21
 */
@ConfigurationProperties(prefix = "jwiki.security")
public class JWikiSecurityConfig {
    private boolean anonymous;

    public boolean isAnonymous() {
        return anonymous;
    }

    public void setAnonymous(boolean anonymous) {
        this.anonymous = anonymous;
    }
}
