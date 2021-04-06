package com.example.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class Post implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    private String title;
    private String content;
    private Admin admin;
    private Date date;

}
