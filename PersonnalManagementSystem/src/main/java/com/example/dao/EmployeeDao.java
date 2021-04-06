package com.example.dao;

import com.example.domain.Employee;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface EmployeeDao {

    public List<Employee> findEmployees(Map<String,Object> map);

    public Integer getCount(Map<String,Object> map);

    public Integer addEmployee(Employee employee);

    public Integer updateEmployee(Employee employee);

    public Integer deleteEmployee(String id);

}
