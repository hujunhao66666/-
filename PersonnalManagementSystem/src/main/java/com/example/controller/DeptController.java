package com.example.controller;

import com.example.domain.Department;
import com.example.service.DepartmentService;

import com.example.util.ResponseUtil;
import net.sf.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/dept")
public class DeptController {
    @Autowired
    private DepartmentService departmentService;

    @RequestMapping("/list")
    public String list(HttpServletResponse response, Department department) throws IOException {
        HashMap<String, Object> map = new HashMap<>();
        if (department.getName()!=null && !"".equals(department.getName().trim())){
            map.put("name","%"+department.getName()+"%");
        }

        List<Department> deptList = departmentService.findDepartments(map);
        Integer total = departmentService.getCount(map);
        JSONObject result = new JSONObject();
        JSONArray jsonArray = JSONArray.fromObject(deptList);
        result.put("rows",jsonArray);
        result.put("total",total);
        ResponseUtil.write(response,result);
        return null;
    }

    @RequestMapping("/save")
    public String save(HttpServletResponse response,HttpServletRequest request,Department department) throws IOException {
        int resultTotal=0;
        if (department.getId()!=null ){
            resultTotal=departmentService.addDepartment(department);
        }else{
            resultTotal=departmentService.updateDepartment(department);
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
    public String delete(@RequestParam(value = "ids")String ids, HttpServletResponse response) throws IOException {
        String[] idsStr = ids.split(",");
        JSONObject result = new JSONObject();
        for (int i=0;i<idsStr.length;i++){
            try{
                departmentService.deleteDepartment(Integer.parseInt(idsStr[i]));
                result.put("success",true);
            }catch (Exception e){
                result.put("success",false);
            }
        }

        ResponseUtil.write(response,result);
        return null;
    }

    @RequestMapping("/getcombobox")
    @ResponseBody
    public JSONArray getDept(HttpServletRequest request){
        HashMap<String, Object> map = new HashMap<>();
        List<Department> deptList = departmentService.findDepartments(map);
        ArrayList<Map<String, Object>> list = new ArrayList<>();
        for (Department department:deptList){
            HashMap<String, Object> result = new HashMap<>();
            result.put("id",department.getId());
            result.put("name",department.getName());
            list.add(result);
        }

        JSONArray jsonArray = JSONArray.fromObject(list);
        return jsonArray;
    }
}
