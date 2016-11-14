package com.aohuan.dodo.coordinator.doa.doa2;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.aohuan.dodo.coordinator.R;

public class MainA2Activity extends AppCompatActivity {

    Toolbar toolbar;
    AppBarLayout abl;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_a2);
        tv = (TextView) findViewById(R.id.tv1);
        abl = (AppBarLayout) findViewById(R.id.abl);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                finish();
                Toast.makeText(getApplication(), "NavigationOnClickListener", Toast.LENGTH_SHORT).show();
                isTvGone = !isTvGone;
                tv.setVisibility(isTvGone?View.GONE:View.VISIBLE);
            }
        });
        setTextBoolean();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_a2, menu);
        return true;
    }


    boolean isTvGone = false;

    //scroll: SCROLL_FLAG_SCROLL    所有想滚动出屏幕的view都需要设置这个flag， 没有设置这个flag的view将被固定在屏幕顶部。
    boolean isScroll = true;
    //snap: SCROLL_FLAG_SNAP    在滚动结束后，如果view只是部分可见，它将滑动到最近的边界。
    boolean isSnap = false;
    //enterAlways:  SCROLL_FLAG_ENTER_ALWAYS    这个flag让任意向下的滚动都会导致该view变为可见，启用快速“返回模式”。
    boolean isEnterAlways = false;
    //enterAlwaysCollapsed: SCROLL_FLAG_ENTER_ALWAYS_COLLAPSED  当你的视图已经设置minHeight属性又使用此标志时，你的视图只能已最小高度进入，只有当滚动视图到达顶部时才扩大到完整高度。
    boolean isEnterAlwaysCollapsed = false;
    //exitUntilCollapsed:   SCROLL_FLAG_EXIT_UNTIL_COLLAPSED    滚动退出屏幕，最后折叠在顶端。
    boolean isExitUntilCollapsed = false;

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        String msg = "";

        switch (item.getItemId()) {
            case R.id.scroll:
                isScroll = !isScroll;
                msg += "Click scroll " + isScroll;
                break;
            case R.id.snap:
                isSnap = !isSnap;
                msg += "Click snap " + isSnap;
                break;
            case R.id.enterAlways:
                isEnterAlways = !isEnterAlways;
                msg += "Click enterAlways " + isEnterAlways;
                break;
            case R.id.enterAlwaysCollapsed:
                isEnterAlwaysCollapsed = !isEnterAlwaysCollapsed;
                msg += "Click enterAlwaysCollapsed " + isEnterAlwaysCollapsed;
                break;
            case R.id.exitUntilCollapsed:
                isExitUntilCollapsed = !isExitUntilCollapsed;
                msg += "Click exitUntilCollapsed " + isExitUntilCollapsed;
                break;
        }

        if(!msg.equals("")) {
            Toast.makeText(getApplication(), msg, Toast.LENGTH_SHORT).show();
        }
        setTextBoolean();
        setToolbarLayoutFlag();

        return super.onOptionsItemSelected(item);
    }

    public void setTextBoolean(){
        tv.setText("【isScroll:"+isScroll+"】【isSnap:"+isSnap+"】\n【isEnterAlways:"+isEnterAlways+"】【isEnterAlwaysCollapsed:"+isEnterAlwaysCollapsed+"】\n【isExitUntilCollapsed:"+isExitUntilCollapsed+"】");//!!!###
    }


    private void setToolbarLayoutFlag(){
        AppBarLayout.LayoutParams params = (AppBarLayout.LayoutParams) toolbar.getLayoutParams();

        params.setScrollFlags(  (isScroll?AppBarLayout.LayoutParams.SCROLL_FLAG_SCROLL:0)
                | (isSnap?AppBarLayout.LayoutParams.SCROLL_FLAG_SNAP:0)
                | (isEnterAlways?AppBarLayout.LayoutParams.SCROLL_FLAG_ENTER_ALWAYS:0)
                | (isEnterAlwaysCollapsed?AppBarLayout.LayoutParams.SCROLL_FLAG_ENTER_ALWAYS_COLLAPSED:0)
                | (isExitUntilCollapsed?AppBarLayout.LayoutParams.SCROLL_FLAG_EXIT_UNTIL_COLLAPSED:0));
        toolbar.setLayoutParams(params);
    }

}
