package pers.cgglyle.service.acconut.filter;

import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author cgglyle
 * @date 2021-12-29 16:45
 */
public class SecurityAuthenticationFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        if ((request.getContentType() == null && request.getContentLength() > 0)||(request.getContentType() != null && !request.getContentType().contains("1"))){
            filterChain.doFilter(request,response);
        }
    }
}
