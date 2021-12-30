package pers.cgglyle.service.acconut.filter;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.SignatureException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import pers.cgglyle.common.response.ApiException;
import pers.cgglyle.service.acconut.model.dto.UserLoginDto;
import pers.cgglyle.service.acconut.service.LoginService;

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
     * <p>
     * 功能：
     * (1) 查看是否携带Token
     * (2) 检查Token是否正确
     * (3) 生层内部Token并放入Security上下文
     */
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        // 获取请求头
        String authorization = request.getHeader("Authorization");
        // 判断请求头是否为空，并且有没有Bearer标识
        if (!StringUtils.isNotBlank(authorization) || !authorization.startsWith("Bearer_")) {
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
//            Collection<GrantedAuthority> userRole = userLoginDto.getAuthorities();
//            List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
//            /*
//            TODO 下面这部分需要重新改进，for循环有点丑陋
//            此部分功能是将LinkedHashMap从userRole中提取出来，并且转化为Collection<GrantedAuthority>集合
//             */
//            for (int i = 0; i < userRole.size(); i++) {
//                LinkedHashMap hashMap = (LinkedHashMap) ((ArrayList) userRole).get(i);
//                GrantedAuthority grantedAuthority = new SimpleGrantedAuthority((String) hashMap.get("authority"));
//                grantedAuthorities.add(grantedAuthority);
//            }
            // 生成内部token
            UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(userLoginDto, null, userLoginDto.getAuthorities());
            // 将token放入上下文
            SecurityContextHolder.getContext().setAuthentication(token);
        } catch (NoSuchAlgorithmException | InvalidKeySpecException | ExpiredJwtException | SignatureException | ApiException e) {
            e.printStackTrace();
            chain.doFilter(request, response);
        }
        // 继续拦截链
        chain.doFilter(request, response);
    }
}
