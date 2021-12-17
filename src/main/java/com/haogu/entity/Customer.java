package com.haogu.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 客户表
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("tb_crm_customer")
public class Customer{
    @TableId(type = IdType.AUTO)
    private Integer id;//客户编号
    @TableField("owner_user_id")
    private Integer owneruserid;//拥有者编号

    @TableField("creator_user_id")
    private Integer creatoruserid;//创建者编号

    @TableField("name")
    private String names;//客户名称（公司名）

    private String origin;//客户信息来源
    private String address;//客户联系地址
    @TableField("zip_code")
    private String zipcode;//邮编
    private String industry;//客户所属行业
    @TableField("annual_revenue")
    private String annualrevenue;//年营业额
    private String ownership;//公司性质
    private String rating;//评分
    @TableField(fill = FieldFill.INSERT,value = "create_time")
    private Date createtime;//创建时间
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date update_time;//更新时间
    private Integer delete_status;//是否删除
    private Integer is_locked;//是否锁定
    private Integer delete_user_id;//删除人
    private Date delete_time;//删除时间
}
