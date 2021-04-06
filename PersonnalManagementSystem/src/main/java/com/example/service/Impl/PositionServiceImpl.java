package com.example.service.Impl;

import com.example.dao.PositionDao;
import com.example.domain.Position;
import com.example.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("positionService")
public class PositionServiceImpl implements PositionService {
    @Autowired
    private PositionDao positionDao;


    @Override
    public List<Position> findPositions(Map<String, Object> map) {
        return positionDao.findPositions(map);
    }

    @Override
    public Integer getCount(Map<String, Object> map) {
        return positionDao.getCount(map);
    }

    @Override
    public Integer addPosition(Position position) {
        return positionDao.addPosition(position);
    }

    @Override
    public Integer updatePosition(Position position) {
        return positionDao.updatePosition(position);
    }

    @Override
    public Integer deletePosition(Integer id) {
        Integer flag=null;
        try {
            flag=positionDao.deletePosition(id);
        }catch (Exception e){
            throw new RuntimeException();
        }

        return flag;
    }
}
