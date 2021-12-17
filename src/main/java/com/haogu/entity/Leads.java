package com.haogu.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("tb_crm_leads")
public class Leads {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private Integer ownerUserId;
    private Integer creatorUserId;
    private String name;
    private String position;
    private String contactsName;
    private String saltname;
    private String mobile;
    private String email;
    @TableField(fill=FieldFill.INSERT)
    private Date createTime;
    @TableField(fill=FieldFill.INSERT_UPDATE)
    private Date updateTime;
    @TableLogic
    private Integer deleteStatus;
    private Integer deleteUserId;
    private Date deleteTime;
    private Integer isTransformed;
    private Integer transformUserId;
    private Integer contactsId;
    private Integer customerId;
    private Integer businessId;
    private String nextstep;
    private Date nextstepTime;
    @TableField(fill=FieldFill.INSERT)
    private Date haveTime;
    private String address;
    private String source;
    private String leadnote;

}
