package com.aohuan.dodo.javacode.rx.demo;

import com.aohuan.dodo.javacode.rx.demo.bean.Person;

import java.util.ArrayList;

import rx.Observable;
import rx.Subscription;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by dodo_lihao on 2016/12/8.
 * qq: 2390183798
 */
public class Demo5 {
    public static void main(String[] args) {
        Demo5 d5 = new Demo5();
//        d5.rxScheduler();
        d5.rxScheduler2();
    }



    private void rxScheduler() {

        Observable.just(getListNum())

                .observeOn(Schedulers.immediate())
                .subscribeOn(Schedulers.immediate())

                .map(new Func1<ArrayList<Integer>, ArrayList<Integer>>() {
                    @Override
                    public ArrayList<Integer> call(ArrayList<Integer> integers) {
                        for (int i = 0; i < integers.size(); i++) {
                            if (integers.get(i) % 1000 == 0) {
                                System.out.println(integers.get(i) + " in map");
                            }
                        }
                        return integers;
                    }
                }).subscribe(new Action1<ArrayList<Integer>>() {
            @Override
            public void call(ArrayList<Integer> integers) {
                for (int i = 0; i < integers.size(); i++) {
                    if (integers.get(i) % 1000 == 0) {
                        System.out.println(integers.get(i) + "--- onNext in Observer --");
                    }
                }
            }
        });

    }

    private void rxScheduler2() {
        Subscription subscription = Observable.just(getListNum())
//                .observeOn(Schedulers.newThread())
//                .subscribeOn(Schedulers.immediate())

                .observeOn(Schedulers.immediate())
                .subscribeOn(Schedulers.immediate())

                .map(new Func1<ArrayList<Integer>, ArrayList<Integer>>() {
                    @Override
                    public ArrayList<Integer> call(ArrayList<Integer> integers) {
                        for (int i = 0; i < integers.size(); i++) {
                            if (integers.get(i) % 1000 == 0) {
                                System.out.println(integers.get(i) + " in map");
                            }
                        }
                        return integers;
                    }
                }).subscribe(new Action1<ArrayList<Integer>>() {
            @Override
            public void call(ArrayList<Integer> integers) {
                for (int i = 0; i < integers.size(); i++) {
                    if (integers.get(i) % 1000 == 0) {
                        System.out.println(integers.get(i) + "--- onNext in Observer --");
                    }
                }
            }
        });




        //取消订阅
        if (!subscription.isUnsubscribed()) {
            subscription.unsubscribe();
        }
    }



    private ArrayList<Integer> getListNum(){
        ArrayList<Integer> intList = new ArrayList<>();
        for(int i=0; i<10000; i++){
            intList.add(i);
        }
        return intList;
    }




}
