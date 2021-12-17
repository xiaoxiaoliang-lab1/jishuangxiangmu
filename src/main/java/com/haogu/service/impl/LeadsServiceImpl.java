package com.haogu.service.impl;

import com.haogu.entity.Leads;
import com.haogu.entity.VLeads;
import com.haogu.mapper.LeadsMapper;
import com.haogu.service.LeadsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class LeadsServiceImpl implements LeadsService {
    @Resource
    private LeadsMapper leadsMapper;

    public boolean insertLeads(Leads leads){
        int insert = leadsMapper.insert(leads);
        return insert == 1 ? true : false;

    }

    public List<VLeads> searchLeads(Integer pageNum, Integer pageSize){
        List<VLeads> vLeads = leadsMapper.searchLeads((pageNum-1)*pageSize, pageSize);
        return vLeads;
    }

    public int rows(){
        Integer integer = leadsMapper.selectCount(null);
        return integer;
    }
    public Leads selectLeadsById(Integer id){
        Leads leads = leadsMapper.selectById(id);
        return leads;
    }

}
