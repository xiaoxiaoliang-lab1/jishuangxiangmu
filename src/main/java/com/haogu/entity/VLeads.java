package com.haogu.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VLeads {

    private Integer id;
    private String name;
    private String contactsName;
    private String saltname;
    private String mobile;
    private String nextstep;
    private Date nextstepTime;
    private String ownerName;
    private String createName;
    private Date createTime;
    private Integer diffDay;









}
