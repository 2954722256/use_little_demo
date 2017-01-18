package com.aohuan.dodo.common.utils.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.aohuan.dodo.common.utils.adapter.bean.ChildBean;
import com.aohuan.dodo.common.utils.adapter.bean.TypeBean;

import java.util.ArrayList;

/**
 * Created by dodo_lihao on 2017/1/17.
 * qq: 2390183798
 */
public class ExpandableListViewaAdapter extends BaseExpandableListAdapter {
    ArrayList<TypeBean> mTypeChildList ;

    Context mContext;


    public ExpandableListViewaAdapter(Context context, ArrayList<TypeBean> typeChildList){
        mContext = context;
        mTypeChildList = typeChildList;
    }


    @Override
    public int getGroupCount() {
        return mTypeChildList.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return mTypeChildList.get(groupPosition).childBeanList.size();
    }

    @Override
    public TypeBean getGroup(int groupPosition) {
//            return "title " + groupPosition;
        return mTypeChildList.get(groupPosition);
    }

    @Override
    public ChildBean getChild(int groupPosition, int childPosition) {
//            return "content " + childPosition;
        return mTypeChildList.get(groupPosition).childBeanList.get(childPosition);
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

        TextView textView = new TextView(mContext);
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
                        Toast.makeText(mContext, "没有设置，嘿嘿！！！", Toast.LENGTH_SHORT).show();
                    } else {
                        mContext.startActivity(new Intent(mContext, ((ChildBean) obj).cls));
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
