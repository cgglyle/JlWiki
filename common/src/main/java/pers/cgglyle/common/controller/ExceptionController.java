package pers.cgglyle.common.controller;

import io.jsonwebtoken.ExpiredJwtException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pers.cgglyle.common.response.ApiException;

import javax.servlet.http.HttpServletRequest;

/**
 * @author cgglyle
 * @date 2021-12-29 15:54
 */
@RestController
@RequestMapping("/exception")
public class ExceptionController {
    /**
     * 拦截器异常处理机制
     * 通过下面的方法将异常转发到此处进行处理
     * <p>
     * request.setAttribute("filter", e);
     * request.getRequestDispatcher("/exception/filter").forward(request, response);
     */
    @RequestMapping("/filter")
    public void filterException(HttpServletRequest request) throws Exception {
        if (request.getAttribute("filter") instanceof ExpiredJwtException e) {
            throw new ApiException(e.getMessage());
        }
        throw new ApiException(((Exception) request.getAttribute("filter")).getMessage());
    }
}
