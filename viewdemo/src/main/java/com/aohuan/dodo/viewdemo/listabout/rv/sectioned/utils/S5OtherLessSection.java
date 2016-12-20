package com.aohuan.dodo.viewdemo.listabout.rv.sectioned.utils;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.aohuan.dodo.viewdemo.R;
import com.aohuan.dodo.viewdemo.listabout.rv.sectioned.lib.StatelessSection;

import java.util.List;

/**
 * Created by dodo_lihao on 2016/12/16.
 * qq: 2390183798
 */
public class S5OtherLessSection extends StatelessSection {



    String title;
    List<String> list;

    public S5OtherLessSection(String title, List<String> list) {
        super(R.layout.item_section_ex5_header, R.layout.item_section_ex5_item_empty);

        this.title = title;
        this.list = list;
    }

    @Override
    public int getContentItemsTotal() {
        return 1;
    }

    @Override
    public RecyclerView.ViewHolder getItemViewHolder(View view) {
        return new EmptyViewHolder(view);   //空的内容，所以是一个为 0dp的Layout
    }

    @Override
    public void onBindItemViewHolder(RecyclerView.ViewHolder holder, int position) {
        //空的内容，所以是一个为 0dp的Layout， 不需要绑定数据
    }

    @Override
    public RecyclerView.ViewHolder getHeaderViewHolder(View view) {
        return new ItemImageViewHolder(view);
    }

    @Override
    public void onBindHeaderViewHolder(RecyclerView.ViewHolder holder) {
        final ItemImageViewHolder headerHolder = (ItemImageViewHolder) holder;
        headerHolder.tvItem.setText(title);
    }


    private static class EmptyViewHolder extends RecyclerView.ViewHolder {
        EmptyViewHolder(View itemView) {
            super(itemView);
        }
    }

    class ItemImageViewHolder extends RecyclerView.ViewHolder {

        private final View rootView;
        private final ImageView imgItem;
        private final TextView tvItem;

        public ItemImageViewHolder(View view) {
            super(view);

            rootView = view;
            imgItem = (ImageView) view.findViewById(R.id.iv);
            tvItem = (TextView) view.findViewById(R.id.tvTitle);
        }
    }

}
