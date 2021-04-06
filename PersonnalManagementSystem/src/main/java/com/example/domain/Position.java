package com.example.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class Position implements Serializable {
    private Integer id;
    private String name;
    private String description;
}
