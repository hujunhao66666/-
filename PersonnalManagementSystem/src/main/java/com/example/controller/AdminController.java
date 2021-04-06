package com.example.controller;

import com.example.domain.Admin;
import com.example.service.AdminService;

import com.example.util.ResponseUtil;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @RequestMapping("/login")
    public String login(Admin admin, HttpServletRequest request, HttpSession session){
        Admin resultAdmin = adminService.login(admin);
        if (resultAdmin==null){
            request.setAttribute("admin",admin);
            request.setAttribute("errorMsg","Please check your username and password!");
            return "login";
        }else{
            session.setAttribute("currentAdmin",resultAdmin);
            session.setAttribute("username",resultAdmin.getUsername());
            return "redirect:main";
        }
    }

    @RequestMapping(value = "/main")
    public String test (Model model)throws Exception{
        return "home_page";
    }

    @RequestMapping("/list")
    public String list(Admin admin, HttpServletResponse response) throws IOException {
        HashMap<String, Object> map = new HashMap<>();
        if (admin.getUsername()!=null && !"".equals(admin.getUsername().trim())){
            map.put("username","%"+admin.getUsername().trim()+"%");
        }

        List<Admin> adminList = adminService.findAdmins(map);
        Integer total = adminService.getCount(map);
        JSONObject result = new JSONObject();
        JSONArray jsonArray = JSONArray.fromObject(adminList);
        result.put("rows",jsonArray);
        result.put("total",total);
        ResponseUtil.write(response,result);
        return null;
    }

    @RequestMapping("/save")
    public String save(Admin admin,HttpServletRequest request,HttpServletResponse response) throws IOException {
        int resultTotal=0;
        if (admin.getId()!=null){
            resultTotal=adminService.addAdmin(admin);
        }else{
            resultTotal=adminService.updateAdmin(admin);
        }

        JSONObject result = new JSONObject();
        if (resultTotal>0){
            result.put("success",true);
        }else{
            result.put("success",false);
        }
        ResponseUtil.write(response,result);
        return null;
    }

    @RequestMapping("/delete")
    public String delete(@RequestParam(value = "ids")String ids,HttpServletResponse response,HttpSession session) throws IOException {
        JSONObject result = new JSONObject();
        String[] idsStr=ids.split(",");
        for (int i=0;i<idsStr.length;i++){
            if (idsStr[i].equals("1") || idsStr[i].equals(((Admin)session.getAttribute("currentAdmin")).getId().toString())){
                result.put("success",false);
                continue;
            }else{
                adminService.deleteAdmin(Integer.parseInt(idsStr[i]));
                result.put("success",true);
            }
        }
        ResponseUtil.write(response,result);
        return null;
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:/login.jsp";
    }
}
