package com.example.service.Impl;

import com.example.dao.EmployeeDao;
import com.example.domain.Employee;
import com.example.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;

    @Override
    public List<Employee> findEmployees(Map<String, Object> map) {
        return employeeDao.findEmployees(map);
    }

    @Override
    public Integer getCount(Map<String, Object> map) {
        return employeeDao.getCount(map);
    }

    @Override
    public Integer addEmployee(Employee employee) {
        Integer flag=null;
        try {
            flag = employeeDao.addEmployee(employee);
        }catch (Exception e){
            throw new RuntimeException();
        }

        return flag;
    }

    @Override
    public Integer updateEmployee(Employee employee) {
        return employeeDao.updateEmployee(employee);
    }

    @Override
    public Integer deleteEmployee(String id) {
        return employeeDao.deleteEmployee(id);
    }
}
