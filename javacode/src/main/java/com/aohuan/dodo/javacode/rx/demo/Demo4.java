package com.aohuan.dodo.javacode.rx.demo;

import com.aohuan.dodo.javacode.rx.demo.bean.Person;

import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func1;

/**
 * Created by dodo_lihao on 2016/12/8.
 * qq: 2390183798
 * <p>
 * 主要对 map的理解
 */
public class Demo4 {

    public static void main(String[] args) {
        Demo4 d4 = new Demo4();
//        d4.rxMap();
//        d4.rxMap2();
        d4.rxFlatMap();
    }


    /**
     * map  就是对象的变化
     * 把传如的内容， 简单处理， 得到新的对象
     * 这里只是简单处理，类型都是String
     * 处理后，也可以是其他类型
     */
    private void rxMap() {
        Observable.just("hello", "hello2").map(new Func1<String, String>() {
            @Override
            public String call(String s) {
                return "in map :" + s;
            }
        }).subscribe(new Action1<String>() {
            @Override
            public void call(String s) {
                System.out.println("--- onNext in Observer --");
                System.out.println(s);
            }
        });
    }


    /**
     * map  就是对象的变化
     * 把传如的内容， 简单处理， 得到新的对象
     * <p>
     * 这里传入一个Person， 根据年龄， 简单做修改传出
     */
    private void rxMap2() {
        Person p1 = new Person("dodo1", 38);
        Person p2 = new Person("dodo2", 25);
        Observable.just(p1, p2).map(new Func1<Person, Person>() {
            @Override
            public Person call(Person s) {
                if (s.getAge() > 30) {
                    s.setAge(s.getAge() - 5);
                }
                return s;
            }
        }).subscribe(new Action1<Person>() {
            @Override
            public void call(Person s) {
                System.out.println("--- onNext in Observer --");
                System.out.println(s.getName() + " : " + s.getAge());
            }
        });
    }

    /**
     * flatMap  和map 类似，
     * 把传如的内容， 简单处理， 得到新的对象
     * <p>
     * 这里传入一个Person， 根据年龄， 简单做修改传出
     */
    private void rxFlatMap(){
        Person p1 = new Person("dodo1", 38);
        Person p2 = new Person("dodo2", 25);
        Observable.just(p1, p2).flatMap(new Func1<Person, Observable<Person>>() {
            @Override
            public Observable<Person> call(Person s) {
                if (s.getAge() > 30) {
                    s.setAge(s.getAge() - 5);
                }
                return Observable.just(s);
            }
        }).subscribe(new Action1<Person>() {
            @Override
            public void call(Person s) {
                System.out.println("--- onNext in Observer --");
                System.out.println(s.getName() + " : " + s.getAge());
            }
        });
    }


}


