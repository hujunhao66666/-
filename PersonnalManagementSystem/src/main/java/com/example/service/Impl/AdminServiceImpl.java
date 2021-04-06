package com.example.service.Impl;

import com.example.dao.AdminDao;
import com.example.domain.Admin;
import com.example.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("adminService")
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminDao adminDao;

    @Override
    public Admin login(Admin admin) {
        return adminDao.login(admin);
    }

    @Override
    public List<Admin> findAdmins(Map<String, Object> map) {
        return adminDao.findAdmins(map);
    }

    @Override
    public Integer getCount(Map<String, Object> map) {
        return adminDao.getCount(map);
    }

    @Override
    public Integer addAdmin(Admin admin) {
        return adminDao.addAdmin(admin);
    }

    @Override
    public Integer updateAdmin(Admin admin) {
        return adminDao.updateAdmin(admin);
    }

    @Override
    public Integer deleteAdmin(Integer id) {
        return adminDao.deleteAdmin(id);
    }
}
