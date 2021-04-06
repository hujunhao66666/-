package com.example.service;

import com.example.domain.Employee;

import java.util.List;
import java.util.Map;

public interface EmployeeService {
    public List<Employee> findEmployees(Map<String,Object> map);

    public Integer getCount(Map<String,Object> map);

    public Integer addEmployee(Employee employee);

    public Integer updateEmployee(Employee employee);

    public Integer deleteEmployee(String id);
}
