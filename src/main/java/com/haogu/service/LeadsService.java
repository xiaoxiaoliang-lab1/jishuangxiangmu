package com.haogu.service;

import com.haogu.entity.Leads;
import com.haogu.entity.VLeads;


import java.util.List;

public interface LeadsService {
    boolean insertLeads(Leads leads);
    List<VLeads> searchLeads(Integer pageNum, Integer pageSize);
    int rows();
    Leads selectLeadsById(Integer id);
}
