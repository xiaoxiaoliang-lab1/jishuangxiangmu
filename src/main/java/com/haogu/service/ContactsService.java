package com.haogu.service;

import com.haogu.entity.Contacts;

import java.util.List;

public interface ContactsService {
    public Contacts selectContacts(Integer id);

    public List<Contacts> selectContactsList(Integer id);

//    public void change(Contacts contacts);
}
