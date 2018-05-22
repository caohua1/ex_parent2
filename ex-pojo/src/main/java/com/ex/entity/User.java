package com.ex.entity;

import lombok.Data;

import java.util.Date;

@Data
public class User {
    private Long id;
    private String username;
    private String password;
    private Date registTime;
    private Date updateTime;
    private Integer status;
}
