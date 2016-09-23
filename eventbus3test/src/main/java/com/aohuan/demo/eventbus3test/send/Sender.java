package com.aohuan.demo.eventbus3test.send;


import com.aohuan.demo.eventbus3test.bean.MessageBean2;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by Administrator on 2016/9/22.
 */
public class Sender {
    public static void doSend1(MessageBean2 bean){
        EventBus.getDefault().post(bean);
    }
}
