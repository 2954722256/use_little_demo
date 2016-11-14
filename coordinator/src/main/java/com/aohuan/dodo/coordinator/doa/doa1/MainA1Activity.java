package com.aohuan.dodo.coordinator.doa.doa1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.aohuan.dodo.coordinator.R;

/**
 * Created by dodo_lihao on 2016/11/9.
 * qq: 2390183798
 *
 * 简单的ToolBar， 用icon显示
 */
public class MainA1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_a1);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_a1, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        String msg = "";
        switch (item.getItemId()) {
            case R.id.basketball:
                msg += "Click basketball00";
                break;
            case R.id.volleyball:
                msg += "Click volleyball00";
                break;
            case R.id.football:
                msg += "Click football00";
                break;
        }

        if(!msg.equals("")) {
            Toast.makeText(getApplication(), msg, Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }


}
