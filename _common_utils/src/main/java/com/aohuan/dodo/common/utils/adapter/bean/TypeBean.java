package com.aohuan.dodo.common.utils.adapter.bean;

import java.util.ArrayList;

/**
 * Created by dodo_lihao on 2017/1/17.
 * qq: 2390183798
 */
public class TypeBean {
    public TypeBean(String name) {
        this.name = name;
    }

    public String name;
    public ArrayList<ChildBean> childBeanList = new ArrayList<>();
}
