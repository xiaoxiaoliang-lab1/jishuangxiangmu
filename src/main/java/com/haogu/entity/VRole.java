package com.haogu.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class VRole {
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

    private String createby;

    private String updateby;
}
