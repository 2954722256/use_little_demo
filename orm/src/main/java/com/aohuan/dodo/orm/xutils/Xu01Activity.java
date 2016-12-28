package com.aohuan.dodo.orm.xutils;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.aohuan.dodo.orm.R;
import com.aohuan.dodo.orm.xutils.bean.Child;
import com.zhy.adapter.recyclerview.CommonAdapter;
import com.zhy.adapter.recyclerview.base.ViewHolder;

import org.xutils.DbManager;
import org.xutils.ex.DbException;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class Xu01Activity extends AppCompatActivity {

    @InjectView(R.id.toolbar)
    Toolbar toolbar;
    @InjectView(R.id.abl)
    AppBarLayout abl;
    @InjectView(R.id.id_recyclerview)
    RecyclerView mRecyclerView;

    @InjectView(R.id.btnAdd)
    Button mBtnAdd;
    @InjectView(R.id.et01)
    EditText mEtName;
    @InjectView(R.id.et02)
    EditText mEtAge;

    ArrayList<Child> strArray = new ArrayList<>();

    CommonAdapter<Child> mCommonAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xu01);
        ButterKnife.inject(this);
        init();
    }

    private void init() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mCommonAdapter = new CommonAdapter<Child>(this, R.layout.item_xu01, strArray) {
            @Override
            protected void convert(ViewHolder viewHolder, Child item, int position) {
                viewHolder.setText(R.id.tvAge, item.getAge() + "");
                viewHolder.setText(R.id.tvName, item.getName());
            }
        });
        addData();
    }

    @OnClick({R.id.btnAdd})
    public void onClick(View view) {
        switch (view.getId()) {
//            case R.id.et02:
//                break;
            case R.id.btnAdd:
                doAdd();
                break;
        }
    }

    private void doAdd() {
        Toast.makeText(Xu01Activity.this, "click", Toast.LENGTH_SHORT).show();
        String name = getText(mEtName, "请输入名字");
        String age = getText(mEtName, "请输入年龄");
        if (name == null || age == null) {
            return;
        }
//        DbManager db = x.getDb(App.getConfig());
        DbManager db = x.getDb(new DbManager.DaoConfig());
        int ageInt = 0;
        try {
            ageInt = Integer.valueOf(age);
        } catch (Exception e) {
            Toast.makeText(Xu01Activity.this, "age", Toast.LENGTH_SHORT).show();
        }
        Child child = new Child();
        child.setName(name);
        child.setAge(ageInt);
        try {
            db.save(child);
        } catch (DbException e) {
            e.printStackTrace();
        }

        addData();

    }

    private String getText(EditText et, String toastString) {
        if (et.getText() == null || et.getText().toString().trim().length() == 0) {
            Toast.makeText(Xu01Activity.this, toastString, Toast.LENGTH_SHORT).show();
            return null;
        }
        return et.getText().toString().trim();
    }


    private void addData() {
        try {
            DbManager db = x.getDb(new DbManager.DaoConfig());
            List<Child> list = db.selector(Child.class).findAll();
            if (list != null && list.size() != 0) {
                strArray = (ArrayList) list;
//                mCommonAdapter.notifyItemInserted(0);
//                mCommonAdapter.notifyDataSetChanged();
                mCommonAdapter.notifyItemInserted(0);
//                mRecyclerView.notifyAll();
            }
        } catch (DbException e) {
            e.printStackTrace();
        }
        Toast.makeText(Xu01Activity.this, "done", Toast.LENGTH_SHORT).show();
    }

    private void addDataAndNotify(int i) {

    }

    private void deleteDataAndNotify(int i) {
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_o2, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        String msg = "";

        switch (item.getItemId()) {
            case R.id.o21:
                addDataAndNotify(1);
                break;
//            case R.id.o22:
//                deleteDataAndNotify(1);
//                break;
//            case R.id.o23:
//
//                break;
//            case R.id.o24:
//
//                break;
//            case R.id.o25:
//
//                break;
//            case R.id.o26:
//
//                break;
//            case R.id.o27:
//
//                break;
//            case R.id.o28:
//
//                break;
//            case R.id.o29:
//
//                break;
        }

        if (!msg.equals("")) {
            Toast.makeText(getApplication(), msg, Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }


}
