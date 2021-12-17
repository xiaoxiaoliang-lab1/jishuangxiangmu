package com.haogu.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("tb_system_function")
public class Function {
    @TableId(type = IdType.AUTO)
    private Integer id;
    @TableField(value = "createTime",fill = FieldFill.INSERT)
    private Date createTime;

    private String funccode;

    private String funcname;

    private String funcnote;

    private Integer functype;

    private String funcurl;

    private String iconclass;

    private String iconurl;

    private Integer sortnum;

    private Integer status;
    @TableField(value = "updateTime",fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

    private String createby;

    private Integer parentid;

    private String updateby;
}
