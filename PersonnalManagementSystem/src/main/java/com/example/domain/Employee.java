package com.example.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class Employee implements Serializable {
    private String id;
    private String name;
    private String sex;
    private String phone;
    private String email;
    private String address;
    private String education;
    private Date birthday;
    private Department department;
    private Position position;
}
