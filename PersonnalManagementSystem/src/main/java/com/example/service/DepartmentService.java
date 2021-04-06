package com.example.service;

import com.example.domain.Department;

import java.util.List;
import java.util.Map;

public interface DepartmentService {
    public List<Department> findDepartments(Map<String,Object> map);

    public Integer getCount(Map<String,Object> map);

    public Integer addDepartment(Department department);

    public Integer deleteDepartment(Integer id);

    public Integer updateDepartment(Department department);
}
