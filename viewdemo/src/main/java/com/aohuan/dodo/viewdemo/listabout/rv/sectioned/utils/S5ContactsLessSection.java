package com.aohuan.dodo.viewdemo.listabout.rv.sectioned.utils;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.aohuan.dodo.viewdemo.R;
import com.aohuan.dodo.viewdemo.listabout.rv.sectioned.lib.SectionedRecyclerViewAdapter;
import com.aohuan.dodo.viewdemo.listabout.rv.sectioned.lib.StatelessSection;

import java.util.List;

/**
 * Created by dodo_lihao on 2016/12/16.
 * qq: 2390183798
 */
public class S5ContactsLessSection extends StatelessSection {
    String title;
    List<String> list;
    boolean expanded = true;
    Context mContext;
    SectionedRecyclerViewAdapter sectionAdapter;

    public S5ContactsLessSection(Context context, String title, List<String> list, SectionedRecyclerViewAdapter sectionAdapter) {
        super(R.layout.item_section_ex4_header, R.layout.item_section_ex1_item);
        this.mContext = context;
        this.title = title;
        this.list = list;
        this.sectionAdapter = sectionAdapter;
    }

    @Override
    public int getContentItemsTotal() {
        return expanded?list.size() : 0;
    }

    @Override
    public RecyclerView.ViewHolder getItemViewHolder(View view) {
        return new ItemViewHolder(view);
    }

    @Override
     public void onBindItemViewHolder(RecyclerView.ViewHolder holder, int position) {
        final ItemViewHolder itemHolder = (ItemViewHolder) holder;

        String name = list.get(position);

        itemHolder.tvItem.setText(name);
        itemHolder.imgItem.setImageResource(R.drawable.xiaohei);

        itemHolder.rootView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, String.format("Clicked on position #%s of Section %s", sectionAdapter.getSectionPosition(itemHolder.getAdapterPosition()), title), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public RecyclerView.ViewHolder getHeaderViewHolder(View view) {
        return new HeaderViewHolder(view);
    }

    @Override
    public void onBindHeaderViewHolder(RecyclerView.ViewHolder holder) {
        final HeaderViewHolder headerHolder = (HeaderViewHolder) holder;

        headerHolder.tvTitle.setText(title);

        headerHolder.rootView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expanded = !expanded;
                headerHolder.imgArrow.setImageResource(
                        expanded ? android.R.drawable.arrow_up_float : android.R.drawable.arrow_down_float
                );
                sectionAdapter.notifyDataSetChanged();
            }
        });
    }

    class HeaderViewHolder extends RecyclerView.ViewHolder {

        private final View rootView;
        private final TextView tvTitle;
        private final ImageView imgArrow;

        public HeaderViewHolder(View view) {
            super(view);

            rootView = view;
            tvTitle = (TextView) view.findViewById(R.id.tvTitle);
            imgArrow = (ImageView) view.findViewById(R.id.imgArrow);
        }
    }

    class ItemViewHolder extends RecyclerView.ViewHolder {

        private final View rootView;
        private final ImageView imgItem;
        private final TextView tvItem;

        public ItemViewHolder(View view) {
            super(view);

            rootView = view;
            imgItem = (ImageView) view.findViewById(R.id.imgItem);
            tvItem = (TextView) view.findViewById(R.id.tvItem);
        }
    }

}
