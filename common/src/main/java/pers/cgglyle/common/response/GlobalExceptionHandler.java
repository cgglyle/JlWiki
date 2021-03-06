package pers.cgglyle.common.response;

import io.jsonwebtoken.ExpiredJwtException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import pers.cgglyle.common.enums.ResultCode;

import java.security.SignatureException;

/**
 * 全局异常处理控制器
 *
 * @author cgglyle
 * @date 2021-12-08 10:46
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * Api请求失败
     *
     * @param e Api错误信息
     * @return 返回体
     */
    @ExceptionHandler(ApiException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Result apiExceptionHandler(ApiException e) {
        logger.warn(ResultCode.FAILED.getMessage(), e);
        return new Result(ResultCode.FAILED, e.getMessage());
    }

    /**
     * 空指针异常
     *
     * @param e 空指针异常信息
     * @return 返回体
     */
    @ExceptionHandler(NullPointerException.class)
    public Result nullPointerExceptionHandler(NullPointerException e) {
        logger.warn(ResultCode.NULL_POINTER.getMessage(), e);
        return new Result(ResultCode.NULL_POINTER, e.getMessage());
    }

    /**
     * 安全框架登陆异常
     *
     * @param e 登陆异常信息
     * @return 返回体
     */
    @ExceptionHandler(BadCredentialsException.class)
    public Result badCredentialsException(BadCredentialsException e) {
        logger.warn(ResultCode.LOGIN_ERROR.getMessage(), e);
        return new Result(ResultCode.LOGIN_ERROR, e.getMessage());
    }

    /**
     * JWT签名与本地计算机不符
     *
     * @param e JWT异常信息
     * @return 返回体
     */
    @ExceptionHandler(SignatureException.class)
    public Result signatureException(SignatureException e) {
        logger.warn(ResultCode.LOGIN_ERROR.getMessage(), e);
        return new Result(ResultCode.LOGIN_ERROR, e.getMessage());
    }

    /**
     * JWT过期异常
     *
     * @param e 异常信息
     * @return 返回体
     */
    @ExceptionHandler(ExpiredJwtException.class)
    public Result expiredJwtException(ExpiredJwtException e) {
        logger.warn(ResultCode.LOGIN_ERROR.getMessage(), e);
        return new Result(ResultCode.LOGIN_ERROR, e.getMessage());
    }

    /**
     * 未知异常
     *
     * @param e 未知异常信息
     * @return 返回体
     */
    @ExceptionHandler(Exception.class)
    public Result exception(Exception e) {
        logger.error(ResultCode.SERVICE_ERROR.getMessage(), e);
        return new Result(ResultCode.SERVICE_ERROR, e.getMessage());
    }
}
