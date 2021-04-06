package com.example.service.Impl;

import com.example.dao.DepartmentDao;
import com.example.domain.Department;
import com.example.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("departmentService")
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    private DepartmentDao departmentDao;


    @Override
    public List<Department> findDepartments(Map<String, Object> map) {
        return departmentDao.findDepartments(map);
    }

    @Override
    public Integer getCount(Map<String, Object> map) {
        return departmentDao.getCount(map);
    }

    @Override
    public Integer addDepartment(Department department) {
        return departmentDao.addDepartment(department);
    }

    @Override
    public Integer deleteDepartment(Integer id) {
        Integer flag=null;
        try {
            flag = departmentDao.deleteDepartment(id);
        }catch (Exception e){
            throw new RuntimeException();
        }

        return flag;
    }

    @Override
    public Integer updateDepartment(Department department) {
        return departmentDao.updateDepartment(department);
    }
}
