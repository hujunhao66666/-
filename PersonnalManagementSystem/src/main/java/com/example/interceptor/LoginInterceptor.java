package com.example.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor implements HandlerInterceptor {
    private static final String[] IGNORE_URI={"/login"};

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        boolean flag=false;

        String url = request.getServletPath();
        for (String s:IGNORE_URI){
            if (url.contains(s)){
                flag=true;
                break;
            }
        }

        if (!flag){
            String username = (String) request.getSession().getAttribute("username");
            if (username==null){
                request.setAttribute("message","Please log in first!");
                request.getRequestDispatcher("/login.jsp")
                        .forward(request,response);
            }else{
                flag=true;
            }
        }
        return flag;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
