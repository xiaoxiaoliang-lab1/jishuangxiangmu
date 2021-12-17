package com.haogu.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("tb_system_role")
public class Role {
    @TableId(type = IdType.AUTO)
    private Integer id;
    @TableField(value = "createTime",fill = FieldFill.INSERT)
    private Date createTime;

    private String rolename;

    private String rolenote;

    private Long sortnum;

    private BigDecimal status;
    @TableField(value = "updateTime",fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

    private Integer createby;

    private Integer updateby;
}
