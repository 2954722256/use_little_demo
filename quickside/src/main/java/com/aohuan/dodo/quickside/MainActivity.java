package com.aohuan.dodo.quickside;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.TextView;
import android.widget.Toast;

import com.aohuan.dodo.quickside.saiwu.S1Activity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ExpandableListView mEListView;
    List<String> mStringArrayList;  //所有的字符，这里为了方便，没有分组
    List<String> mStringTopList;    //对应的top类型的list

//    ArrayList<>

    ArrayList<TypeBean> typeChildList = new ArrayList<>();//对应bean的list

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        // 允许使用transitions
//        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
//
//        // 设置一个exit transition
//        getWindow().setExitTransition(new Explode());
        setContentView(R.layout.activity_main);
        mEListView = (ExpandableListView) findViewById(R.id.list2);
        mStringArrayList = Arrays.asList(getResources().getStringArray(R.array.typelist));
        mStringTopList = Arrays.asList(getResources().getStringArray(R.array.typetop));

        setBean();

        mEListView.setAdapter(new ExpandableListViewaAdapter());
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
            } else if (i >= PART_A && i < PART_B) {
                typeChildList.get(1).childBeanList.add(bean);
            } else if (i >= PART_B && i < PART_N) {
                typeChildList.get(2).childBeanList.add(bean);
            } else if (i >= PART_N) {
                typeChildList.get(3).childBeanList.add(bean);
            }
        }
    }

    //    public static final int PART_0 = 0;
    public static final int PART_A = 4;
    public static final int PART_B = PART_A + 6;
    public static final int PART_N = PART_B + 5;


    private ChildBean setIndexBean(int i, String name) {
        switch (i) {
            ////===========PART 1
            case 0:
                return setBeanName(name, S1Activity.class);
//            case 1:
//                return setBeanName(name, LvHyMutiActivity.class);
//            case 2:
//                return setBeanName(name, RvHyCommonActivity.class);
//            case 3:
//                return setBeanName(name, RvHyMutiActivity.class);
//
//            case PART_A + 0:
//                ChildBean cb0 = setBeanName(name, T0MidActivity.class);
//                cb0.intOther = 0;
//                return cb0;
//            case PART_A + 1:
//                ChildBean cb1 = setBeanName(name, T0MidActivity.class);
//                cb1.intOther = 1;
//                return cb1;
//            case PART_A + 2:
//                ChildBean cb2 = setBeanName(name, T0MidActivity.class);
//                cb2.intOther = 2;
//                return cb2;
//            case PART_B + 0:
//                return setBeanName(name, RvS1Activity.class);
//            case PART_B + 1:
//                return setBeanName(name, RvS2Activity.class);
//            case PART_B + 2:
//                return setBeanName(name, RvS3Activity.class);
//            case PART_B + 3:
//                return setBeanName(name, RvS4Activity.class);
//            case PART_B + 4:
//                return setBeanName(name, RvS5Activity.class);

        }
        return new ChildBean();
    }

    ChildBean setBeanName(String name, Class cls) {
        ChildBean bean = new ChildBean();
        bean.name = name;
        bean.cls = cls;
        return bean;
    }

    class ExpandableListViewaAdapter extends BaseExpandableListAdapter {

        @Override
        public int getGroupCount() {
            return typeChildList.size();
        }

        @Override
        public int getChildrenCount(int groupPosition) {
            return typeChildList.get(groupPosition).childBeanList.size();
        }

        @Override
        public TypeBean getGroup(int groupPosition) {
//            return "title " + groupPosition;
            return typeChildList.get(groupPosition);
        }

        @Override
        public ChildBean getChild(int groupPosition, int childPosition) {
//            return "content " + childPosition;
            return typeChildList.get(groupPosition).childBeanList.get(childPosition);
        }

        @Override
        public long getGroupId(int groupPosition) {
            return groupPosition;
        }

        @Override
        public long getChildId(int groupPosition, int childPosition) {
            return childPosition;
        }

        @Override
        public boolean hasStableIds() {
            return false;
        }

        @Override
        public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
            return getGenericView(getGroup(groupPosition));
        }

        @Override
        public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
            return getGenericView(getChild(groupPosition, childPosition));
        }

        @Override
        public boolean isChildSelectable(int groupPosition, int childPosition) {
            return true;
        }

        private TextView getGenericView(final Object obj) {

            int tvHeight = 100;

            TextView textView = new TextView(getApplicationContext());
            textView.setGravity(Gravity.CENTER_VERTICAL | Gravity.LEFT);
            textView.setPadding(40, 0, 0, 0);

            //====

            String string = "no Contents";
            if (obj instanceof TypeBean) {
                string = ((TypeBean) obj).name;
                tvHeight = 300;
                textView.setBackgroundColor(Color.GRAY);
            } else if (obj instanceof ChildBean) {
                string = ((ChildBean) obj).name;
                tvHeight = 200;
                final Class cls = ((ChildBean) obj).cls;
                textView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (cls == null) {
                            Toast.makeText(getApplicationContext(), "没有设置，嘿嘿！！！", Toast.LENGTH_SHORT).show();
                        } else {
                            beforeStart(((ChildBean) obj));
                            startActivity(new Intent(getApplication(), ((ChildBean) obj).cls));
                        }

                    }
                });
            } else {

            }
            AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    tvHeight);
            textView.setLayoutParams(layoutParams);
            textView.setText(string);
            textView.setTextColor(Color.BLACK);
            return textView;
        }

    }

    private void beforeStart(ChildBean obj) {
//        Log.e("type", T0MidActivity.class.getName() + "  beforeStart -- m00  " + obj.cls.getName());
//        if(obj.cls.getName().equals(T0MidActivity.class.getName())){
//            if(obj.intOther == 0){
//                ConstantsT.setAnimType(ConstantsT.AnimType.ANIM_TYPE_STRAIGHT);
//            }else if(obj.intOther == 1){
//                ConstantsT.setAnimType(ConstantsT.AnimType.ANIM_TYPE_CIRCULAR_REVEAL);
//            }else if(obj.intOther == 2){
//                ConstantsT.setAnimType(ConstantsT.AnimType.ANIM_TYPE_RECT_REVEAL);
//            }
//            Log.e("type", ConstantsT.getAnimType().toString() + " -- m00");
//        }
    }

    class TypeBean {
        TypeBean(String name) {
            this.name = name;
        }

        String name;
        ArrayList<ChildBean> childBeanList = new ArrayList<>();
    }

    class ChildBean {
        String name;
        Class cls;
        int intOther;
    }


}
