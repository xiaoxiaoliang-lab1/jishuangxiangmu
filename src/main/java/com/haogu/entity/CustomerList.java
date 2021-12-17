package com.haogu.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerList{
    private Integer id;
    private String name;
    private String industry;
    private String rating;
    private String address;
    private String owner;
    private String createUser;
    private Date createTime;
    private Date updateTime;
}
