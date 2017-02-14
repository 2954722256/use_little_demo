package com.aohuan.middleware;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ExpandableListView;

import com.alibaba.android.arouter.launcher.ARouter;
import com.aohuan.dodo.common.utils.adapter.ExpandableListViewaAdapter;
import com.aohuan.dodo.common.utils.adapter.bean.ChildBean;
import com.aohuan.dodo.common.utils.adapter.bean.ICallBack;
import com.aohuan.dodo.common.utils.adapter.bean.NameHelper;
import com.aohuan.dodo.common.utils.adapter.bean.TypeBean;
import com.aohuan.middleware.arouter.ARouter0Activity;
import com.aohuan.middleware.arouter.ARouter1Activity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class MainActivity extends AppCompatActivity {

    @InjectView(R.id.list2)
    ExpandableListView mEListView;

    List<String> mStringArrayList;  //所有的字符，这里为了方便，没有分组
    List<String> mStringTopList;    //对应的top类型的list

    ArrayList<TypeBean> typeChildList = new ArrayList<>();//对应bean的list

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        ButterKnife.inject(this);
        ARouter.init(getApplication());
        initData();
    }

    private void initData() {
        mStringArrayList = Arrays.asList(getResources().getStringArray(R.array.typelist));
        mStringTopList = Arrays.asList(getResources().getStringArray(R.array.typetop));

        setBean();
        mEListView.setAdapter(new ExpandableListViewaAdapter(this, typeChildList));
    }

    private void setBean() {
        //添加top
        for (int i = 0; i < mStringTopList.size(); i++) {
            typeChildList.add(new TypeBean(mStringTopList.get(i)));
        }

        for (int i = 0; i < mStringArrayList.size(); i++) {
            ChildBean bean = setIndexBean(i, mStringArrayList.get(i));
            if (i < PART_A) {
                typeChildList.get(0).childBeanList.add(bean);
            }
//            else if (i >= PART_A && i < PART_B) {
//                typeChildList.get(1).childBeanList.add(bean);
//            } else if (i >= PART_B && i < PART_R) {
//                typeChildList.get(2).childBeanList.add(bean);
//            } else if (i >= PART_R  && i < PART_RC) {
//                typeChildList.get(3).childBeanList.add(bean);
//            } else if (i >= PART_RC && i < PART_T){
//                typeChildList.get(4).childBeanList.add(bean);
//            }else if (i >= PART_T && i < PART_U){
//                typeChildList.get(5).childBeanList.add(bean);
//            }else if (i >= PART_U){
//                typeChildList.get(6).childBeanList.add(bean);
//            }
        }
    }

    public static final int NUM_0 = 4;
//    public static final int NUM_A = 6;
//    public static final int NUM_B = 5;
//    public static final int NUM_R = 6;
//    public static final int NUM_RC = 6;
//    public static final int NUM_T = 6;


    public static final int PART_0 = 0;
    public static final int PART_A = PART_0 + NUM_0;
//    public static final int PART_B = PART_A + NUM_A;
//    public static final int PART_R = PART_B + NUM_B;
//    public static final int PART_RC = PART_R + NUM_R;
//    public static final int PART_T = PART_RC + NUM_RC;
//    public static final int PART_U = PART_T + NUM_T;



    private ChildBean setIndexBean(int i, String name) {
//        ChildBean bean = new ChildBean();

        switch (i) {
            ////===========PART 1
            case 0:
//                return NameHelper.setBeanName(name, ARouter0Activity.class);
                return NameHelper.setBeanOther(name, new ICallBack() {
                    @Override
                    public void doSth() {
                        ARouter.getInstance()
                                .build("/test/activity0")
                                .navigation();
                    }
                });
            case 1:
//                return NameHelper.setBeanName(name, ARouter1Activity.class);
            return NameHelper.setBeanOther(name, new ICallBack() {
                @Override
                public void doSth() {
                    ARouter.getInstance()
                            .build("/test/activity1")
                            .navigation();
                }
            });
//            case PART_U + 0:
//                return setBeanName(name, Uni01Activity.class);

        }
        return new ChildBean();
    }
}
