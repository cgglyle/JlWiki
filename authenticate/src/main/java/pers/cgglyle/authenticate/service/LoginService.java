package pers.cgglyle.authenticate.service;

import org.springframework.stereotype.Service;
import pers.cgglyle.authenticate.model.dto.UserLoginDto;
import pers.cgglyle.authenticate.model.query.LoginQuest;
import pers.cgglyle.authenticate.model.vo.UserInfo;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

/**
 * 登陆系统服务接口
 *
 * @author cgglyle
 * @date 2021-12-27 08:32
 */
@Service
public interface LoginService {
    /**
     * 根据用户数据模型创建Token
     * <p> 传进来的用户模型会根据以下信息创建
     * <ul>
     * <li> 用户主键id
     * <li> 用户名
     * <li> 头像url
     * <li> 角色
     * <li> 昵称
     * <li> 随机生成的盐
     * <li> 日期
     * <li> 过期时间
     * </ul>
     * <p> 生成的Token携带以上信息，并且通过RSA256私钥加密。
     * <p> 特别说明：
     * <p> 盐是Token的验证方式，当通过此方法创建一个Toke的时候会通过UUID创建一个唯一的盐。
     * 盐会在解Token的时候进行验证。
     * 当盐验证失败此Token就会失效。
     *
     * @param userLoginDto 用户数据模型
     * @return Token
     */
    String createToken(UserLoginDto userLoginDto) throws NoSuchAlgorithmException, InvalidKeySpecException;

    /**
     * 解析Token
     * <p> 传进来的Token会用RSA256公钥解密并验证其中的盐是否正确
     * 不正确会返回一个null
     *
     * @param token Token
     * @return 用户显示模型，不正确会返回null
     */
    UserLoginDto parserToken(String token) throws NoSuchAlgorithmException, InvalidKeySpecException;

    /**
     * 登陆接口
     *
     * @param loginQuest 登陆请求
     * @return 返回一个登陆用户相关信息
     */
    UserInfo login(LoginQuest loginQuest) throws NoSuchAlgorithmException, InvalidKeySpecException;

    /**
     * 重置用户的盐信息
     * <p> 盐是由UUID生成
     *
     * @param id 用户id
     * @return true-成功, false-失败
     */
    boolean logout(String id);
}
