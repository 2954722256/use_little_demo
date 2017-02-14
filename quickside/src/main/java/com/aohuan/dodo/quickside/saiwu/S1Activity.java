package com.aohuan.dodo.quickside.saiwu;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.aohuan.dodo.quickside.R;
import com.aohuan.dodo.quickside.saiwu.adapter.CityListAdapter;
import com.aohuan.dodo.quickside.saiwu.bean.City;
import com.aohuan.dodo.quickside.saiwu.utils.DataHelper;
import com.aohuan.dodo.quickside.saiwu.utils.DividerDecoration;
import com.bigkoo.quicksidebar.QuickSideBarTipsView;
import com.bigkoo.quicksidebar.QuickSideBarView;
import com.bigkoo.quicksidebar.listener.OnQuickSideBarTouchListener;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.timehop.stickyheadersrecyclerview.StickyRecyclerHeadersAdapter;
import com.timehop.stickyheadersrecyclerview.StickyRecyclerHeadersDecoration;

import java.lang.reflect.Type;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class S1Activity extends AppCompatActivity {


    @InjectView(R.id.recyclerView)
    RecyclerView recyclerView;
    @InjectView(R.id.quickSideBarTipsView)
    QuickSideBarTipsView quickSideBarTipsView;
    @InjectView(R.id.quickSideBarView)
    QuickSideBarView quickSideBarView;

    HashMap<String,Integer> letters = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.saiwu_activity_s1);
        ButterKnife.inject(this);

        doSth();
    }

    private void doSth() {
        setListener();
        setRecycleLayout();
        addHeaderDecore();
    }

    private void addHeaderDecore() {
        // Add the sticky headers decoration
        CityListWithHeadersAdapter adapter = new CityListWithHeadersAdapter();

        //GSON解释出来
        Type listType = new TypeToken<LinkedList<City>>(){}.getType();
        Gson gson = new Gson();
        LinkedList<City> cities = gson.fromJson(DataHelper.cityDataList, listType);

        ArrayList<String> customLetters = new ArrayList<>();

        int position = 0;
        for(City city: cities){
            String letter = city.getFirstLetter();
            //如果没有这个key则加入并把位置也加入
            if(!letters.containsKey(letter)){
                letters.put(letter,position);
                customLetters.add(letter);
            }
            position++;
        }

        //不自定义则默认26个字母
        quickSideBarView.setLetters(customLetters);
        adapter.addAll(cities);
        recyclerView.setAdapter(adapter);

        final StickyRecyclerHeadersDecoration headersDecor = new StickyRecyclerHeadersDecoration(adapter);
        recyclerView.addItemDecoration(headersDecor);

        // Add decoration for dividers between list items
        recyclerView.addItemDecoration(new DividerDecoration(this));
    }

    private void setRecycleLayout() {
        //设置列表数据和浮动header
        final LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
    }

    private void setListener() {
        quickSideBarView.setOnQuickSideBarTouchListener(new OnQuickSideBarTouchListener() {
            @Override
            public void onLetterChanged(String letter, int position, float y) {
                quickSideBarTipsView.setText(letter, position, y);
                //有此key则获取位置并滚动到该位置
                if(letters.containsKey(letter)) {
                    recyclerView.scrollToPosition(letters.get(letter));
                }
            }

            @Override
            public void onLetterTouching(boolean touching) {
                quickSideBarTipsView.setVisibility(touching? View.VISIBLE:View.INVISIBLE);
            }
        });
    }


    private class CityListWithHeadersAdapter extends CityListAdapter<RecyclerView.ViewHolder>
            implements StickyRecyclerHeadersAdapter<RecyclerView.ViewHolder> {
        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.saiwu_view_item, parent, false);
            return new RecyclerView.ViewHolder(view) {
            };
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            TextView textView = (TextView) holder.itemView;
            textView.setText(getItem(position).getCityName());
        }

        @Override
        public long getHeaderId(int position) {
            return getItem(position).getFirstLetter().charAt(0);
        }

        @Override
        public RecyclerView.ViewHolder onCreateHeaderViewHolder(ViewGroup parent) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.saiwu_view_header, parent, false);
            return new RecyclerView.ViewHolder(view) {
            };
        }

        @Override
        public void onBindHeaderViewHolder(RecyclerView.ViewHolder holder, int position) {
            TextView textView = (TextView) holder.itemView;
            textView.setText(String.valueOf(getItem(position).getFirstLetter()));
            holder.itemView.setBackgroundColor(getRandomColor());
        }

        private int getRandomColor() {
            SecureRandom rgen = new SecureRandom();
            return Color.HSVToColor(150, new float[]{
                    rgen.nextInt(359), 1, 1
            });
        }

    }

}
