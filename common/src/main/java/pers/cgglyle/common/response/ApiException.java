package pers.cgglyle.common.response;

/**
 * Api异常实体
 *
 * @author cgglyle
 * @date 2021-12-08 10:41
 */
public class ApiException extends RuntimeException {
    /**
     * 异常代码
     */
    private final Integer code;
    /**
     * 异常信息
     */
    private final String message;

    public ApiException() {
        this(ResultCode.FAILED);
    }

    public ApiException(ResultCode failed) {
        this.code = failed.getCode();
        this.message = failed.getMessage();
    }

    public ApiException(String message) {
        this.code = ResultCode.SERVICE_ERROR.getCode();
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }

}
