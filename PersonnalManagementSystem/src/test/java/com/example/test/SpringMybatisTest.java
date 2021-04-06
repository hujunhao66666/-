package com.example.test;

import com.example.domain.Admin;
import com.example.service.AdminService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-mybatis.xml"})
public class SpringMybatisTest {

    @Autowired
    private AdminService adminService;

    @Test
    public void testLogin(){
        Admin admin = new Admin();
        admin.setUsername("superadmin");
        admin.setPassword("123456");
        System.out.println(adminService.login(admin));
    }

    @Test
    public void testFind(){
        List<Admin> admins = adminService.findAdmins(new HashMap<>());
        for (Admin admin : admins) {
            System.out.println(admin);
        }
    }

    @Test
    public void testGetCount(){
        Integer count = adminService.getCount(new HashMap<>());
        System.out.println(count);
    }
}
