package com.example.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

//将用HttpServletResponse返回前台JSON格式数据，同时减少Controller层代码冗余
public class ResponseUtil {
    public static void write(HttpServletResponse response,Object o) throws IOException {
        response.setContentType("text/html;charset=utf-8");
        response.addHeader("Access-Control-Allow-Origin","*");
        PrintWriter out = response.getWriter();
        out.println(o.toString());
        out.flush();
        out.close();
    }
}
