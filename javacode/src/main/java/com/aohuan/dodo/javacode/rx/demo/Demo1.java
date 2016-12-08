package com.aohuan.dodo.javacode.rx.demo;

import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.subjects.Subject;

/**
 * Created by dodo_lihao on 2016/12/7.
 * qq: 2390183798
 *
 * Observable 被观察者， 触发action，  相当于 按钮或者View
 *  Observer 观察者， 获得触发的action，  相当于 OnClickListener
 *  通过  observable.subscribe(observer) 绑定 ， 相当于 setOnClickListener
 */
public class Demo1 {
    public static void main(String[] agrs) {
        rxHello();
    }

    public static void rxHello() {
        //观察者
        Observer<String> observer = new Observer<String>() {
            @Override
            public void onCompleted() {
                System.out.println("--- onCompleted in Observer --");
            }
            @Override
            public void onError(Throwable e) {
                System.out.println("--- onError in Observer --");
            }
            @Override
            public void onNext(String s) {
                System.out.println("--- onNext in Observer --");
                System.out.println(s);
            }
        };

        //被观察者
        Observable<String> observable = Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                subscriber.onNext("Hello world_1");
                subscriber.onNext("Hello world_2");
                subscriber.onNext("Hello world_3");
                subscriber.onCompleted();
            }
        });
        //订阅
        observable.subscribe(observer);
    }
}
