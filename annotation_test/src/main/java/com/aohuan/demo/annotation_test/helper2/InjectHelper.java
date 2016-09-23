package com.aohuan.demo.annotation_test.helper2;

/**
 * Created by dodo in Administrator on 2015/9/7.
 * qq  2390183798
 */
public class InjectHelper {
    public static int injectObject(Object handler) throws Exception {

        Class<?> handlerType = handler.getClass();

        // inject ContentView
        AhView contentView = handlerType.getAnnotation(AhView.class);
        if (contentView != null) {
            try {
                return contentView.value();
            } catch (Throwable e) {
                throw new RuntimeException("No injection layout");
            }
        }else{
            throw new RuntimeException("No injection layout");
        }
    }
}
