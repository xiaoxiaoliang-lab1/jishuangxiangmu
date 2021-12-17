package com.haogu.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("tb_system_user")
public class User {
    @TableId(type= IdType.AUTO)
    private Integer id;
    @TableField(value = "createTime",fill = FieldFill.INSERT)
    private Date createTime;

    private String email;

    private String password;

    private String phone;

    private String salt;
    @TableField(value = "sortNum")
    private Long sortNum;

    private Long status;
    @TableField(value = "updateTime",fill = FieldFill.INSERT_UPDATE)

    private Date updateTime;
    @TableField(value = "userNote")
    private String userNote;

    private String username;
    @TableField(value = "createBy")
    private String createBy;
    @TableField(value = "updateBy")
    private String updateBy;

    public Integer getId() {
        return id;
    }
}
