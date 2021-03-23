package com.example.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class contentDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    //手动保存功能
    public boolean insert(String content){
        try{
            String sql="insert into w_content(content,createtime,updatetime) values(?,now(),now())";
            Object[] params = {content};

            jdbcTemplate.update(sql,params);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    //刷新最新数据
    public String search(){
        String content=null;
        try{
            String sql="select content from w_content order by updatetime DESC limit 1";
            content=(String)jdbcTemplate.queryForObject(sql,java.lang.String.class);
        }catch (Exception e){
            e.printStackTrace();
        }

        return content;
    }

    public Map<String,Object> query(){
        HashMap<String, Object> modelMap = new HashMap<String, Object>();
        String content=null;
        try{
            String sql="select content from w_content order by updatetime DESC limit 1";
            content=(String)jdbcTemplate.queryForObject(sql,java.lang.String.class);
            modelMap.put("state",true);
            modelMap.put("initcontent",content);
        }catch (Exception e){
            e.printStackTrace();
            content="查询失败";
            modelMap.put("state",false);
            modelMap.put("initcontent",content);
        }

        return modelMap;
    }
}
