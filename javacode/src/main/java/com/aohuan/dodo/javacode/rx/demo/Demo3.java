package com.aohuan.dodo.javacode.rx.demo;

import java.text.SimpleDateFormat;

import rx.Observable;
import rx.functions.Action0;
import rx.functions.Action1;
//import

/**
 * Created by dodo_lihao on 2016/12/8.
 * qq: 2390183798
 *
 *  对 Action1  和  Action0 的理解
 *      调用call方法
 */
public class Demo3 {
    public static void main(String[] args) {
//        rxAction1();
        rxAction0();
    }


    /**
     * Action1的调用
     * 每个 Observable 被观察者 都会触发一次 Action1 的call
     * 根据源码，我们知道，call 就相当于 onNext
     */
    private static void rxAction1() {
        Observable.just("Hello", "Hello" + "[22]").subscribe(new Action1<String>() {
            @Override
            public void call(String s) {
                System.out.println("--- onNext in Observer --");
                System.out.println(s);
            }
        });
    }

    /**
     * 这里对应的 Action1 可以是 onNext ， 也可以是 onError
     *  但是最后的 Action0 是 onCompleted
     */
    private static void rxAction0() {
        Observable observable = Observable.just("hello");
        Action1<String> onNextAction = new Action1<String>() {
            // onNext()
            @Override
            public void call(String s) {
                System.out.println(s);
            }
        };
        Action1<Throwable> onErrorAction = new Action1<Throwable>() {
            // onError()
            @Override
            public void call(Throwable throwable) {
                // Error handling
            }
        };
        Action0 onCompletedAction = new Action0() {
            // onCompleted()
            @Override
            public void call() {
                System.out.println("onCompleted");
            }
        };

        observable.subscribe(onNextAction);// 自动创建 Subscriber ，并使用 onNextAction 来定义 onNext()

        observable.subscribe(onNextAction, onErrorAction);// 自动创建 Subscriber ，并使用 onNextAction 和 onErrorAction 来定义 onNext() 和 onError()

        observable.subscribe(onNextAction, onErrorAction, onCompletedAction);// 自动创建 Subscriber ，并使用 onNextAction、 onErrorAction 和 onCompletedAction 来定义 onNext()、 onError() 和 onCompleted()
    }


    private static String nowTime() {
        SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = sim.format(System.currentTimeMillis());
        return time;
    }
}
