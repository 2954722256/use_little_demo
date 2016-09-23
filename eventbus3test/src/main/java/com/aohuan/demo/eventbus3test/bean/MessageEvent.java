package com.aohuan.demo.eventbus3test.bean;

/**
 * Created by Administrator on 2016/9/22.
 */
public class MessageEvent {
    public final String message;

    public MessageEvent(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
