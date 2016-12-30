package com.aohuan.dodo.viewdemo;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.TextView;
import android.widget.Toast;

import com.aohuan.dodo.viewdemo.listabout.listview.hy.LvHyCommonActivity;
import com.aohuan.dodo.viewdemo.listabout.listview.hy.LvHyMutiActivity;
import com.aohuan.dodo.viewdemo.listabout.rv.hy.RvHyCommonActivity;
import com.aohuan.dodo.viewdemo.listabout.rv.hy.RvHyMutiActivity;
import com.aohuan.dodo.viewdemo.listabout.rv.other.RvO1Activity;
import com.aohuan.dodo.viewdemo.listabout.rv.other.RvO2Activity;
import com.aohuan.dodo.viewdemo.listabout.rv.other.RvO3Activity;
import com.aohuan.dodo.viewdemo.listabout.rv.sectioned.RvS1Activity;
import com.aohuan.dodo.viewdemo.listabout.rv.sectioned.RvS2Activity;
import com.aohuan.dodo.viewdemo.listabout.rv.sectioned.RvS3Activity;
import com.aohuan.dodo.viewdemo.listabout.rv.sectioned.RvS4Activity;
import com.aohuan.dodo.viewdemo.listabout.rv.sectioned.RvS5Activity;
import com.aohuan.dodo.viewdemo.refresh.ReRv01Activity;
import com.aohuan.dodo.viewdemo.refresh.ReRv02Activity;
import com.aohuan.dodo.viewdemo.refresh.ReRv03Activity;
import com.aohuan.dodo.viewdemo.refresh.ReRv04Activity;
import com.aohuan.dodo.viewdemo.refresh.ReRv05Activity;
import com.aohuan.dodo.viewdemo.refresh.ReRv06Activity;
import com.aohuan.dodo.viewdemo.refresh_coordiate.ReCo01Activity;
import com.aohuan.dodo.viewdemo.temp.TabStrip01Activity;
import com.aohuan.dodo.viewdemo.temp.TabStrip02Activity;
import com.aohuan.dodo.viewdemo.temp.TabStrip03Activity;
import com.aohuan.dodo.viewdemo.temp.TabStrip04Activity;

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
            } else if (i >= PART_B && i < PART_R) {
                typeChildList.get(2).childBeanList.add(bean);
            } else if (i >= PART_R  && i < PART_RC) {
                typeChildList.get(3).childBeanList.add(bean);
            } else if (i >= PART_RC && i < PART_T){
                typeChildList.get(4).childBeanList.add(bean);
            }else if (i >= PART_T){
                typeChildList.get(5).childBeanList.add(bean);
            }
        }
    }

    public static final int NUM_0 = 4;
    public static final int NUM_A = 6;
    public static final int NUM_B = 5;
    public static final int NUM_R = 6;
    public static final int NUM_RC = 6;
    public static final int NUM_T = 6;


    public static final int PART_0 = 0;
    public static final int PART_A = PART_0 + NUM_0;
    public static final int PART_B = PART_A + NUM_A;
    public static final int PART_R = PART_B + NUM_B;
    public static final int PART_RC = PART_R + NUM_R;
    public static final int PART_T = PART_RC + NUM_RC;



    private ChildBean setIndexBean(int i, String name) {
//        ChildBean bean = new ChildBean();

        switch (i) {
            ////===========PART 1
            case 0:
                return setBeanName(name, LvHyCommonActivity.class);
            case 1:
                return setBeanName(name, LvHyMutiActivity.class);
            case 2:
                return setBeanName(name, RvHyCommonActivity.class);
            case 3:
                return setBeanName(name, RvHyMutiActivity.class);

            ////===========PART A
            case PART_A + 0:
                return setBeanName(name, RvO1Activity.class);
            case PART_A + 1:
                return setBeanName(name, RvO2Activity.class);
            case PART_A + 2:
                return setBeanName(name, RvO3Activity.class);

            ////===========PART B
            case PART_B + 0:
                return setBeanName(name, RvS1Activity.class);
            case PART_B + 1:
                return setBeanName(name, RvS2Activity.class);
            case PART_B + 2:
                return setBeanName(name, RvS3Activity.class);
            case PART_B + 3:
                return setBeanName(name, RvS4Activity.class);
            case PART_B + 4:
                return setBeanName(name, RvS5Activity.class);

            ////===========PART R
            case PART_R + 0:
                return setBeanName(name, ReRv01Activity.class);
            case PART_R + 1:
                return setBeanName(name, ReRv02Activity.class);
            case PART_R + 2:
                return setBeanName(name, ReRv03Activity.class);
            case PART_R + 3:
                return setBeanName(name, ReRv04Activity.class);
            case PART_R + 4:
                return setBeanName(name, ReRv05Activity.class);
            case PART_R + 5:
                return setBeanName(name, ReRv06Activity.class);

            ////===========PART RC
            case PART_RC + 0:
                return setBeanName(name, ReCo01Activity.class);

            ////===========PART T
            case PART_T + 0:
                return setBeanName(name, TabStrip01Activity.class);
            case PART_T + 1:
                return setBeanName(name, TabStrip02Activity.class);
            case PART_T + 2:
                return setBeanName(name, TabStrip03Activity.class);
            case PART_T + 3:
                return setBeanName(name, TabStrip04Activity.class);

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
    }
}
