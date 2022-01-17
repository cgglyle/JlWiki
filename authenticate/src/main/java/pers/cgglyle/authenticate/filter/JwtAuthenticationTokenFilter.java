package pers.cgglyle.authenticate.filter;


import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.SignatureException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import pers.cgglyle.authenticate.enums.AccountEnum;
import pers.cgglyle.authenticate.model.dto.UserLoginDto;
import pers.cgglyle.authenticate.service.LoginService;
import pers.cgglyle.common.response.ApiException;
import pers.cgglyle.common.utils.StringUtils;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

/**
 * JWT Token 拦截器
 *
 * @author cgglyle
 * @date 2021-12-27 10:32
 */
public class JwtAuthenticationTokenFilter extends BasicAuthenticationFilter {
    @Autowired
    private LoginService loginService;

    public JwtAuthenticationTokenFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);
    }

    /**
     * JWT token 拦截器
     * <p>拦截认证处理，再此处判断处理
     * <ul>
     * 功能：
     * <li> 查看是否携带Token
     * <li> 检查Token是否正确
     * <li> 生层内部Token并放入Security上下文
     * </ul>
     */
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        // 获取请求头
        String authorization = request.getHeader("Authorization");
        // 判断请求头是否为空，并且有没有Bearer标识
        if (!StringUtils.isNotBlank(authorization) || !authorization.startsWith(AccountEnum.TOKEN_HARD.getMessage())) {
            chain.doFilter(request, response);
            return;
        }
        try {
            // 尝试解析token
            UserLoginDto userLoginDto = loginService.parserToken(authorization);
            if (userLoginDto == null) {
                chain.doFilter(request, response);
                return;
            }
            // 生成内部token
            UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(userLoginDto, null, userLoginDto.getAuthorities());
            // 将token放入上下文
            SecurityContextHolder.getContext().setAuthentication(token);
        } catch (NoSuchAlgorithmException | InvalidKeySpecException | ApiException e) {
            e.printStackTrace();
            request.setAttribute("filter", e);
            request.getRequestDispatcher("/exception/filter").forward(request, response);
        } catch (ExpiredJwtException e) {
            e.printStackTrace();
            ApiException ae = new ApiException("Token 已过期");
            request.setAttribute("filter", ae);
            request.getRequestDispatcher("/exception/filter").forward(request, response);
        } catch (SignatureException e) {
            e.printStackTrace();
            ApiException ae = new ApiException("Token RSA 验证失败, Token 不被信任");
            request.setAttribute("filter", ae);
            request.getRequestDispatcher("/exception/filter").forward(request, response);
        }
        // 继续拦截链
        chain.doFilter(request, response);
    }
}
