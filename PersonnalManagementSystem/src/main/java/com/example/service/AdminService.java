package com.example.service;

import com.example.domain.Admin;

import java.util.List;
import java.util.Map;

public interface AdminService {
    public Admin login(Admin admin);

    public List<Admin> findAdmins(Map<String,Object> map);

    public Integer getCount(Map<String,Object> map);

    public Integer addAdmin(Admin admin);

    public Integer updateAdmin(Admin admin);

    public Integer deleteAdmin(Integer id);
}
