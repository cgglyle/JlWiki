package pers.cgglyle.service.acconut.service.impl;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.Base64Utils;
import pers.cgglyle.common.response.ApiException;
import pers.cgglyle.common.util.redis.RedisUtils;
import pers.cgglyle.service.acconut.model.dto.RsaKeyDto;
import pers.cgglyle.service.acconut.model.dto.UserLoginDto;
import pers.cgglyle.service.acconut.model.query.LoginQuest;
import pers.cgglyle.service.acconut.model.vo.UserInfo;
import pers.cgglyle.service.acconut.service.LoginService;

import java.security.*;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Collection;
import java.util.Date;

/**
 * 登陆服务实现
 *
 * @author cgglyle
 * @date 2021-12-27 08:33
 */
public class LoginServiceImpl implements LoginService {
    private static final Long TIMEOUT = 60 * 60 * 1000L;
    private static final String ENCRYPTION = "RSA";
    private static final int KEY_SIZE = 2048;
    private static final Long CACHE_TIMEOUT = 24 * 60 * 60L;
    private static final String REDIS_RSA256_KEY_NAME = "RSA256KEY";
    private static final String REDIS_SALT_KEY_NAME = "SALT";

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private RedisUtils redisUtils;

    /**
     * 创建token
     *
     * @param userLoginDto 用户数据模型
     * @return token
     */
    @Override
    public String createToken(UserLoginDto userLoginDto) throws NoSuchAlgorithmException, InvalidKeySpecException {
        // 超时时间
        Date expireDate = new Date(System.currentTimeMillis() + TIMEOUT);
        // 判断是否有RSA256的密钥
        if (!redisUtils.hasKey(REDIS_RSA256_KEY_NAME)) {
            // 创建密钥生成器并指定为RSA
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(ENCRYPTION);
            // 调整Key的位数为256位
            keyPairGenerator.initialize(KEY_SIZE);
            // 生成一个密钥对
            KeyPair keyPair = keyPairGenerator.generateKeyPair();
            // 密钥对分开存储进RSA实体
            RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();
            RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();
            // 通过Base64加密
            String base64PrivateKey = Base64Utils.encodeToString(privateKey.getEncoded());
            String base64PublicKey = Base64Utils.encodeToString(publicKey.getEncoded());
            // 创建实体存储
            RsaKeyDto rsaKeyDto = new RsaKeyDto();
            rsaKeyDto.setPublicKey(base64PublicKey);
            rsaKeyDto.setPrivateKey(base64PrivateKey);
            // 存入Redis
            redisUtils.set(REDIS_RSA256_KEY_NAME, rsaKeyDto, CACHE_TIMEOUT);
        }
        // 得到密钥对
        RsaKeyDto rsa256Key = (RsaKeyDto) redisUtils.get(REDIS_RSA256_KEY_NAME);
        // Base64解密
        byte[] bytes = Base64Utils.decodeFromString(rsa256Key.getPrivateKey());
        // PKCS8编码
        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(bytes);
        // 创建RSA Key工厂
        KeyFactory factory = KeyFactory.getInstance(ENCRYPTION);
        // 转换为PKCS8私钥
        PrivateKey privateKey = factory.generatePrivate(keySpec);
        // 判断redis中是否有用户的盐
        if (!redisUtils.hHasKey(REDIS_SALT_KEY_NAME, Integer.toString(userLoginDto.getId()))) {
            redisUtils.hset(REDIS_SALT_KEY_NAME, Integer.toString(userLoginDto.getId()), 1);
        }
        // 创建Token
        String token = Jwts.builder()
                // 发布者
                .setIssuer("cgglyle")
                // Token id
                .setId(String.valueOf(userLoginDto.getId()))
                // 角色
                .claim("ROLE", userLoginDto.getAuthorities())
                // 昵称
                .claim("USER_NICK_NAME", userLoginDto.getUserNickName())
                // 头像url
                .claim("USER_ICON", userLoginDto.getUserIcon())
                /*
                 * 特别说明：
                 *
                 * 当用户登陆的时候在Redis中创建一个hash集合并把用户id存进去
                 * 当用户用token访问的时候检查hash中是否有这个id，没有就是token失效，有就是有效
                 * 当需要强制下线用户的时候将这个id从hash中删除
                 * 当更新密码的时候也删除id，保证之前的token失效
                 */
                .claim("SALT", redisUtils.hget(REDIS_SALT_KEY_NAME, Integer.toString(userLoginDto.getId())))
                // 用户名
                .setAudience(userLoginDto.getUsername())
                // 过期时间
                .setExpiration(expireDate)
                // 发布时间
                .setIssuedAt(new Date())
                // 加密方式以及密钥
                .signWith(SignatureAlgorithm.RS256, privateKey)
                // 生成
                .compact();
        return StringUtils.join("Bearer_", token);
    }

    /**
     * 解析Token
     *
     * @param token Token
     * @return 用户显示信息
     */
    @Override
    public UserInfo parserToken(String token) throws NoSuchAlgorithmException, InvalidKeySpecException {
        // 获取RSA256密钥
        RsaKeyDto rsa256Key = (RsaKeyDto) redisUtils.get(REDIS_RSA256_KEY_NAME);
        if (rsa256Key == null) {
            throw new ApiException("RSA过期，请重新登陆");
        }
        // Base64解密密钥
        byte[] bytes = Base64Utils.decodeFromString(rsa256Key.getPublicKey());
        // X509公钥编码
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(bytes);
        KeyFactory factory = KeyFactory.getInstance(ENCRYPTION);
        PublicKey publicKey = factory.generatePublic(keySpec);
        // 解密Token
        Jws<Claims> claimsJws = Jwts.parser().setSigningKey(publicKey).parseClaimsJws(token.replace("Bearer_", ""));
        // 获取Token载荷
        Claims body = claimsJws.getBody();
        // 判断盐是否存在
        if (!redisUtils.hHasKey(REDIS_SALT_KEY_NAME, body.getId())){
            return null;
        }
        // TODO 下面那个丑陋的 (Collection<GrantedAuthority>) body.get("ROLE") 转换需要改进
        return new UserInfo(Integer.parseInt(body.getId()), body.getAudience(), (String) body.get("USER_NICK_NAME"),
                (String) body.get("USER_ICON"), (Collection<GrantedAuthority>) body.get("ROLE"), token);
    }

    @Override
    public UserInfo login(LoginQuest loginQuest) throws NoSuchAlgorithmException, InvalidKeySpecException {
        // 生成内部token
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(loginQuest.getUserName(), loginQuest.getPassword());
        // 验证token是否正确
        Authentication authentication = authenticationManager.authenticate(token);
        // 放入Security上下文
        SecurityContextHolder.getContext().setAuthentication(authentication);
        UserLoginDto userLoginDto = (UserLoginDto) authentication.getPrincipal();
        String userToken = createToken(userLoginDto);
        return new UserInfo(userLoginDto.getId(), userLoginDto.getUsername(), userLoginDto.getUserNickName(), userLoginDto.getUserIcon(), userLoginDto.getAuthorities(), userToken);
    }

    @Override
    public boolean logout(String id) {
        // 删除盐
        redisUtils.hdel(REDIS_SALT_KEY_NAME,id);
        // 检查盐
        return redisUtils.hHasKey(REDIS_SALT_KEY_NAME,id);
    }
}
