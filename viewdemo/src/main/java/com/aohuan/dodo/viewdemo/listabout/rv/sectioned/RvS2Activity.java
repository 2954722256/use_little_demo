package com.aohuan.dodo.viewdemo.listabout.rv.sectioned;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.aohuan.dodo.viewdemo.R;
import com.aohuan.dodo.viewdemo.listabout.rv.sectioned.lib.SectionedRecyclerViewAdapter;
import com.aohuan.dodo.viewdemo.listabout.rv.sectioned.lib.StatelessSection;
import com.aohuan.dodo.viewdemo.listabout.rv.sectioned.utils.DataHelper;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;


/**
 * Header and Footer 的 ListView类型
 *
 *
 */
public class RvS2Activity extends AppCompatActivity {


    @InjectView(R.id.recyclerview)
    RecyclerView recyclerview;

    SectionedRecyclerViewAdapter sectionAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rv_s2);
        ButterKnife.inject(this);
        init();
    }

    private void init() {
        sectionAdapter = new SectionedRecyclerViewAdapter();

        for (char alphabet = 'A'; alphabet <= 'Z'; alphabet++) {
            List<String> contacts = DataHelper.getContactsWithLetter(this, alphabet);

            if (contacts.size() > 0) {
                sectionAdapter.addSection(new HeaderFooterSection(String.valueOf(alphabet), contacts));
            }
        }

        recyclerview.setLayoutManager(new LinearLayoutManager(this));
        recyclerview.setAdapter(sectionAdapter);
    }

    class HeaderFooterSection extends StatelessSection {

        String title;
        List<String> list;

        public HeaderFooterSection(String title, List<String> list) {
            super(R.layout.item_section_ex1_header, R.layout.item_section_ex2_footer, R.layout.item_section_ex1_item);

            this.title = title;
            this.list = list;
        }

        @Override
        public int getContentItemsTotal() {
            return list.size();
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
                    Toast.makeText(RvS2Activity.this, String.format("Clicked on position #%s of Section %s", sectionAdapter.getSectionPosition(itemHolder.getAdapterPosition()), title), Toast.LENGTH_SHORT).show();
                }
            });
        }

        @Override
        public RecyclerView.ViewHolder getHeaderViewHolder(View view) {
            return new HeaderViewHolder(view);
        }

        @Override
        public void onBindHeaderViewHolder(RecyclerView.ViewHolder holder) {
            HeaderViewHolder headerHolder = (HeaderViewHolder) holder;

            headerHolder.tvTitle.setText(title);
        }

        @Override
        public RecyclerView.ViewHolder getFooterViewHolder(View view) {
            return new FooterViewHolder(view);
        }

        @Override
        public void onBindFooterViewHolder(RecyclerView.ViewHolder holder) {
            FooterViewHolder footerHolder = (FooterViewHolder) holder;

            footerHolder.rootView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(RvS2Activity.this, String.format("Clicked on footer of Section %s", title), Toast.LENGTH_SHORT).show();
                }
            });
        }


    }

    class HeaderViewHolder extends RecyclerView.ViewHolder {

        private final TextView tvTitle;

        public HeaderViewHolder(View view) {
            super(view);

            tvTitle = (TextView) view.findViewById(R.id.tvTitle);
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

    class FooterViewHolder extends RecyclerView.ViewHolder {

        private final View rootView;

        public FooterViewHolder(View view) {
            super(view);

            rootView = view;
        }
    }

}
