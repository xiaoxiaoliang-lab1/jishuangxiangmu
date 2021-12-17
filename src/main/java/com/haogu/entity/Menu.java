package com.haogu.entity;

import lombok.Data;

@Data
public class Menu {
    private String id;
    private String funcname;
    private String funcurl;
    private String parentid;

    public Menu(String id, String funcname, String funcurl, String parentid) {
        this.id = id;
        this.funcname = funcname;
        this.funcurl = funcurl;
        this.parentid = parentid;
    }

    public Menu() {
    }
}
