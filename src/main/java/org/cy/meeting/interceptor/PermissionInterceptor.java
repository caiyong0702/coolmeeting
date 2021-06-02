package org.cy.meeting.interceptor;

import org.cy.meeting.model.Employee;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class PermissionInterceptor implements HandlerInterceptor {
    AntPathMatcher pathMatcher=new AntPathMatcher();

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String requesURI=request.getRequestURI();
        if ("/".equals(requesURI) || "/doLogin".equals(requesURI) || "/register".equals(requesURI) || "/doReg".equals(requesURI)){
            return true;
        }
        HttpSession session=request.getSession(true);
        Employee currentuser=(Employee)session.getAttribute("currentuser");
        if(pathMatcher.match("/admin/**",requesURI)){
            if(currentuser != null )
                if (currentuser.getRole() ==2) {
                    return true;
                }else{
                    response.getWriter().write("forbidden");
                    return false;
                }
        }else{
            if (currentuser != null){
                return true;
            }
        }
        response.sendRedirect("/");
        return false;
    }
}
