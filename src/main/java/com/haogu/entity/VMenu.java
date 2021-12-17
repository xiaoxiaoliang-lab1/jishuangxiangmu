package com.haogu.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VMenu {
    private Integer id;

    private String name;

    private String url;

    private String pId;

    private Boolean open;

    private Boolean checked;
}
