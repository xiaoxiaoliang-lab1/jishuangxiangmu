package com.haogu.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 联系人表
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("tb_crm_contacts")
public class Contacts {
    @TableId(type = IdType.AUTO)
    private Integer id;//联系人编号
    private Integer creator_user_id;//创建者
    private String name;//联系人姓名
    private String post;//职位
    private String department;//部门
    private Integer sex;//性别
    private String saltname;//尊称
    private String telephone;//电话
    private String email;//邮箱
    @TableField("qq_no")
    private String qqno;//qq
    private String address;//地址
    @TableField("zip_code")
    private String zipcode;//邮编
    private String description;//备注
    private Integer customer_id;//所属客户id
    @TableField(fill = FieldFill.INSERT)
    private Date create_time;//创建时间
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date update_time;//更新时间
    private Integer delete_status;//是否被删除
    private Integer delete_user_id;//删除人
    private Date delete_time;//删除时间
}
