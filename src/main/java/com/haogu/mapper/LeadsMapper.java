package com.haogu.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.haogu.entity.Leads;

import com.haogu.entity.VLeads;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface LeadsMapper extends BaseMapper<Leads> {
    List<VLeads> searchLeads(@Param("pageNum") Integer pageNum, @Param("pageSize") Integer pageSize);
}
