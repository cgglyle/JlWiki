package pers.cgglyle.common.enums;

/**
 * 结果实体枚举控制
 *
 * @author cgglyle
 * @date 2021-12-08 10:33
 */
public enum ResultCode {
    /**
     * SUCCESS: 操作成功
     * <p> CODE:    1000
     */
    SUCCESS(1000, "操作成功"),
    /**
     * FAILED:  操作失败
     * <p> CODE:    1010
     */
    FAILED(1010, "操作失败"),
    /**
     * SERVICE_ERROR
     * <p> 系统内部错误
     * 所有未指定代码的错误都会调用这个枚举。
     * <p> 例子：
     * {@code throw new ApiException("异常信息")}
     * <p> 上面类型的异常会调用这个枚举。
     */
    SERVICE_ERROR(1020, "系统内部错误"),
    /**
     * NULL_POINTER
     * <p> 空指针异常
     */
    NULL_POINTER(1021, "空指针异常"),
    /**
     * ACCOUNT_ERROR
     * <p> 登陆错误
     */
    LOGIN_ERROR(1500, "登陆错误");

    private final Integer code;
    private final String message;

    ResultCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
