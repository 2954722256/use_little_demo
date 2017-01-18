package com.aohuan.dodo.common.utils.adapter.bean;

/**
 * Created by dodo_lihao on 2017/1/17.
 * qq: 2390183798
 */
public class NameHelper {
    public static ChildBean setBeanName(String name, Class cls) {
        ChildBean bean = new ChildBean();
        bean.name = name;
        bean.cls = cls;
        return bean;
    }
}
