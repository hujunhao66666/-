package com.example.controller;
import javax.annotation.Resource;
import com.example.dao.contentDao;
import com.example.model.Content;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
public class SaveController {
    private Content content;

    @Resource
    private contentDao contentdao;

    /*初始化最新数据*/
    @ResponseBody
    @RequestMapping(value = "initdata",method = RequestMethod.POST)
    public Content toInitData(){
        this.content=new Content();
        this.content.setScontent(contentdao.search());
        System.out.println("content:"+this.content);
        return content;
    }

    /*手动保存*/
    @PostMapping(value = "save")
    @ResponseBody
    public Map<String,Object> doSave(@RequestBody String initcontent){
        boolean state=contentdao.insert(initcontent);
        Map<String,Object> modelMap=new HashMap<String, Object>();
        modelMap.put("state",state);
        return modelMap;
    }
}
