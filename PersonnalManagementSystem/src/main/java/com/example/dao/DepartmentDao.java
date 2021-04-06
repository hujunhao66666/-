package com.example.dao;

import com.example.domain.Department;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface DepartmentDao {
    public List<Department> findDepartments(Map<String,Object> map);

    public Integer getCount(Map<String,Object> map);

    public Integer addDepartment(Department department);

    public Integer deleteDepartment(Integer id);

    public Integer updateDepartment(Department department);
}
