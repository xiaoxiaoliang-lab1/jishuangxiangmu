package com.haogu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.haogu.entity.Contacts;
import com.haogu.mapper.ContactsMapper;
import com.haogu.service.ContactsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ContactsServiceImpl implements ContactsService {
    @Resource
    private ContactsMapper contactsMapper;


    @Override
    public Contacts selectContacts(Integer id) {
        return contactsMapper.selectContacts(id);
//        return contactsMapper.selectById(id);
    }

    @Override
    public List<Contacts> selectContactsList(Integer id) {
        QueryWrapper<Contacts> oq = new QueryWrapper<>();
        oq.eq("customer_id", id);//判断id是否相等
        return contactsMapper.selectList(oq);
    }

    /*@Override
    public void change(Contacts contacts) {
        contactsMapper.updateById(contacts);
    }*/
}
