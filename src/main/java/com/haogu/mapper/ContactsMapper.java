package com.haogu.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.haogu.entity.Contacts;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactsMapper extends BaseMapper<Contacts> {
    Contacts selectContacts(Integer id);
}
