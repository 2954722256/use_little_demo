package com.aohuan.dodo.javacode.reflect.sample1;

import com.aohuan.dodo.javacode.reflect.utils.DUtils;
import com.aohuan.dodo.javacode.reflect.bean.DummyClass;
import com.aohuan.dodo.javacode.reflect.bean.DummyClass2;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by dodo_lihao on 2016/11/27.
 * qq: 2390183798
 */
public class DoConstructor {

    public static void main(String[] args) throws InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        DoConstructor doConstructor = new DoConstructor();
//        doConstructor.getAndPrintConstructors(DummyClass.class);
//        doConstructor.getAndPrintConstructors(DummyClass2.class);


//        doConstructor.doConstructorNewInstance1();
//        doConstructor.doConstructorNewInstance2E();
//        doConstructor.doConstructorNewInstance2R1();
        doConstructor.doConstructorNewInstance2R2();

    }

    /**
     * 打印对应Class的所有构造方法
     *  如果没有构造，会默认调用一个没有参数的构造
     *  也就是 Constructor.newInstance((Object[])null);
     * @param cls   对应的Class
     */
    private void getAndPrintConstructors(Class cls){
        Class<?> c1 = cls;
        Constructor<?>[] cons= c1.getConstructors();
        DUtils.printConstructor(cons);
    }

    /**
     *  我们调用Class的getConstructor的 newInstance((Object[])null);
     *  具体的结果，我们可以看见，和前面DoClass类的newInstance方法结果一样
     * @throws IllegalAccessException
     * @throws InstantiationException
     * @throws NoSuchMethodException
     * @throws InvocationTargetException
     */
    private void doConstructorNewInstance1() throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Class<?> c1 = DummyClass.class;
        DUtils.println(c1.getConstructor().newInstance((Object[]) null).toString());
    }

    /**
     *  我们调用Class的getConstructor的 newInstance("dodo");
     *      会报错，因为源码中，只有没有写构造的时候，才会按上面的流程走
     * @throws IllegalAccessException
     * @throws InstantiationException
     * @throws NoSuchMethodException
     * @throws InvocationTargetException
     */
    private void doConstructorNewInstance2E() throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Class<?> c2 = DummyClass2.class;
        DUtils.println(c2.getConstructor().newInstance("dodo").toString());
    }


    /**
     *  DummyClass2 有2个自己的带参数的构造
     *  如果通过getConstructors得到构造的数组，在调用对应的构造，传入参数即可
     *  这里调用的是第2个，有2个参数的构造
     * @throws IllegalAccessException
     * @throws InstantiationException
     */
    private void doConstructorNewInstance2R1() throws IllegalAccessException, InstantiationException, InvocationTargetException {
        Class<DummyClass2> c2 = DummyClass2.class;
        DUtils.println(c2.getConstructors()[1].newInstance("dodo", 23).toString());
    }


    /**
     *  DummyClass2 有2个自己的带参数的构造
     *  如果通过getConstructors得到构造的数组，在调用对应的构造，传入参数即可
     *  这里调用的是第1个，有1个参数的构造
     * @throws IllegalAccessException
     * @throws InstantiationException
     */
    private void doConstructorNewInstance2R2() throws IllegalAccessException, InstantiationException, InvocationTargetException {
        Class<DummyClass2> c2 = DummyClass2.class;
        DUtils.println(c2.getConstructors()[0].newInstance("dodo").toString());
    }


}
