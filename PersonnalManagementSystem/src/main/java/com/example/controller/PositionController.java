package com.example.controller;

import com.example.domain.Position;
import com.example.service.PositionService;

import com.example.util.ResponseUtil;
import net.sf.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Array;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/position")
public class PositionController {
    @Autowired
    private PositionService positionService;

    @RequestMapping("/list")
    public String list(Position position, HttpServletResponse response) throws IOException {
        HashMap<String, Object> map = new HashMap<>();
        if (position.getName()!=null && !"".equals(position.getName().trim())){
            map.put("name","%"+position.getName()+"%");
        }

        List<Position> dpositionList = positionService.findPositions(map);
        Integer total = positionService.getCount(map);
        JSONObject result = new JSONObject();
        JSONArray jsonArray = JSONArray.fromObject(dpositionList);
        result.put("rows",jsonArray);
        result.put("total",total);
        ResponseUtil.write(response,result);
        return null;
    }

    @RequestMapping("/save")
    public String save(Position position, HttpRequest request, HttpServletResponse response) throws IOException {
        int resultTotal=0;
        if (position.getId()==null){
            resultTotal=positionService.addPosition(position);
        }else{
            resultTotal=positionService.updatePosition(position);
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

    @RequestMapping("/getcombobox")
    @ResponseBody
    public JSONArray getPos(HttpServletRequest request){
        HashMap<String, Object> map = new HashMap<>();
        List<Position> posList = positionService.findPositions(map);
        ArrayList<Map<String, Object>> list = new ArrayList<>();
        for (Position pos:posList){
            HashMap<String, Object> result = new HashMap<>();
            result.put("id",pos.getId());
            result.put("name",pos.getName());
            list.add(result);
        }

        JSONArray jsonArray = JSONArray.fromObject(list);
        return jsonArray;
    }
}
