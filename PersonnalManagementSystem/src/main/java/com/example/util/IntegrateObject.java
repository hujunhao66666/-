package com.example.util;

import com.example.domain.Department;
import com.example.domain.Employee;
import com.example.domain.Position;

//完成Employee、Department和Position对象的关联映射
public class IntegrateObject {
    public static void genericAssociation(Integer dept_id, Integer pos_id, Employee employee){
        Department department = new Department();
        department.setId(dept_id);
        Position position = new Position();
        position.setId(pos_id);
        employee.setDepartment(department);
        employee.setPosition(position);
    }
}
