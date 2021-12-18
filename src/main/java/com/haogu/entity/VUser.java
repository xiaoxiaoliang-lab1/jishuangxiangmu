package com.haogu.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VUser {
    private Integer id;
    private String username;
    private String phone;
    private String email;
    private String roleNames;
    private String createBy;
    private Date createTime;
    private String updateBy;
    private Date updateTime;
    private Integer status;
}
