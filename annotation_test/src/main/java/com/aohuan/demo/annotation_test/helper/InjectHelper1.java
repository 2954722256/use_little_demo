package com.aohuan.demo.annotation_test.helper;

/**
 * Created by dodo in Administrator on 2015/9/7.
 * qq  2390183798
 */
public class InjectHelper1 {
    public static int injectObject(Object handler) throws Exception {

        Class<?> handlerType = handler.getClass();

        // inject ContentView
        AhView1 contentView = handlerType.getAnnotation(AhView1.class);
        if (contentView != null) {
            try {
                return contentView.intR();
            } catch (Throwable e) {
                throw new RuntimeException("No injection layout");
            }
        }else{
            throw new RuntimeException("No injection layout");
        }
    }
}
