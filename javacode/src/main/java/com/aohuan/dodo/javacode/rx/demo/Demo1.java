package com.aohuan.dodo.javacode.rx.demo;

import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.subjects.Subject;

/**
 * Created by dodo_lihao on 2016/12/7.
 * qq: 2390183798
 */
public class Demo1 {
    public static void main(String[] agrs) {
        rxHello();
    }

    public static void rxHello() {
        Observer<String> observer = new Observer<String>() {
            @Override
            public void onCompleted() {
            }
            @Override
            public void onError(Throwable e) {
            }
            @Override
            public void onNext(String s) {
                System.out.println(s);
            }
        };

        Observable<String> observable = Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                subscriber.onNext("Hello world_1");
                subscriber.onNext("Hello world_2");
                subscriber.onNext("Hello world_3");
                subscriber.onCompleted();
            }
        });
        observable.subscribe(observer);
    }
}
