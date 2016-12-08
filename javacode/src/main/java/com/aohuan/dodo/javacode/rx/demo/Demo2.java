package com.aohuan.dodo.javacode.rx.demo;

import rx.Observable;
import rx.Observer;

/**
 * Created by dodo_lihao on 2016/12/8.
 * qq: 2390183798
 *
 * 这里注意理解just方法
 *  也就是简单的create调用
 */
public class Demo2 {
    public static void main(String[] agrs) {
//        rxJust();
//        rxJust2();
//        rxJust3();

    }

    /**
     * just可以理解为简单的create方法
     */
    private static void rxJust() {
        Observable.just("Hello world_1").subscribe(new Observer<String>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(String s) {
                System.out.println("--- onNext in Observer --");
                System.out.println(s);
            }
        });
    }

    /**
     * just也可以传入多个参数
     *  相当于 create中，多次调用 onNext
     */
    private static void rxJust2() {
        Observable.just("Hello world_1", "Hello2").subscribe(new Observer<String>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(String s) {
                System.out.println("--- onNext in Observer --");
                System.out.println(s);
            }
        });
    }

    /**
     * 多次just， 前面的just会被覆盖
     *  简单理解，相当于多次setOnClickListener
     *  前面的会被覆盖
     */
    private static void rxJust3() {
        Observable.just("Hello world_1", "Hello2").just("hello", "H2").subscribe(new Observer<String>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(String s) {
                System.out.println("--- onNext in Observer --");
                System.out.println(s);
            }
        });
    }


}
