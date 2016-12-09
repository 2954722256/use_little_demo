package com.aohuan.dodo.rx.qt5.counter.cont;

import android.app.Activity;
import android.widget.TextView;

import com.aohuan.dodo.rx.qt5.counter.base.IBasePresenter;
import com.aohuan.dodo.rx.qt5.counter.base.IBaseView;

/**
 * Created by dodo_lihao on 2016/12/9.
 * qq: 2390183798
 *      代码来自简书， 英勇青铜5 的文章 http://www.jianshu.com/p/ccd999c7b66a
 */
public class MainContract {
    public interface IMainBiz {
        void onStartByHandler(Activity activity, onStartListener onStartListener);
        void onStartByThread(Activity activity, onStartListener onStartListener);
        void onStop(onStopListener onStopListener);

        interface onStartListener {
            void start(String time);
        }

        interface onStopListener {
            void stop(String info, boolean b);
        }
    }

    public interface IMainView extends IBaseView<IPresenter> {
        void initView();
        void onStop(String info, boolean b);
    }

    public interface IPresenter extends IBasePresenter {
        void startByHandler(Activity activity);
        void startByThread(Activity activity);
        void stop();
        void initView(TextView tv);
        void onRecycler();
    }
}
