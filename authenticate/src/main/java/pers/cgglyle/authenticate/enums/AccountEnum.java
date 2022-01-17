package pers.cgglyle.authenticate.enums;

/**
 * @author cgglyle
 * @date 2022-01-05 16:18
 */
public enum AccountEnum {
    /**
     * Token的请求头标识
     */
    TOKEN_HARD("Bearer_"),
    /**
     * 匿名用户的权限
     * <p> 必须使用ROLE_开头，非常不建议更改，可能会导致未知的异常
     */
    ANONYMOUS("ROLE_ANONYMOUS"),

    ;
    private final String message;

    AccountEnum(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
