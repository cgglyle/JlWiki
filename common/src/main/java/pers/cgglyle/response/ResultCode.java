package pers.cgglyle.response;

/**
 * 结果实体枚举控制
 *
 * @author cgglyle
 * @date 2021-12-08 10:33
 */
public enum ResultCode {
    /**
     * SUCCESS: 操作成功
     * CODE:    1000
     */
    SUCCESS(1000,"操作成功"),
    /**
     * FAILED:  操作失败
     * CODE:    1010
     */
    FAILED(1010,"操作失败"),
    /**
     * SERVICE_ERROR
     *
     * 系统内部错误
     * 所有未指定代码的错误都会调用这个枚举。
     *
     * 例子：
     *  throw new ApiException("异常信息")
     *
     * 上面类型的异常会调用这个枚举。
     */
    SERVICE_ERROR(1020,"系统内部错误"),
    /**
     * NULL_POINTER
     *
     * 空指针异常
     */
    NULL_POINTER(1021,"空指针异常"),
    /**
     * BAD_REQUEST
     *
     * 错误传递了参数
     * 已过时
     * @deprecated BAD_REQUEST
     */
    @Deprecated
    BAD_REQUEST(1040,"错误传递参数");
    private Integer code;
    private String message;

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    ResultCode(Integer code, String message){
        this.code = code;
        this.message = message;
    }
}