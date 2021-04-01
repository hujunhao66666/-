package com.hu.myblog.controller;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;

@Controller
public class downloadController {

    //实现简历下载功能
    @RequestMapping("/download")
    public void downloadConsume(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        try {
            String fileName = "consume.pdf".toString(); // 文件的默认保存名
            // 读到流中
            InputStream inStream = new FileInputStream("E://consume.pdf");//文件的存放路径
            // 设置输出的格式
            response.reset();
            response.setContentType("bin");
            response.addHeader("Content-Disposition",
                    "attachment;filename=" + URLEncoder.encode("consume.pdf", "UTF-8"));
            // 循环取出流中的数据
            byte[] b = new byte[200];
            int len;

            while ((len = inStream.read(b)) > 0){
                response.getOutputStream().write(b, 0, len);
            }
            inStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}

