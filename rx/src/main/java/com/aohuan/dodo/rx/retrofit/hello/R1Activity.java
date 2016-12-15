package com.aohuan.dodo.rx.retrofit.hello;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.aohuan.dodo.rx.R;
import com.aohuan.dodo.rx.qt5.counter.utils.ToastUtils;
import com.aohuan.dodo.rx.retrofit.hello.api.JuHeService;
import com.aohuan.dodo.rx.retrofit.hello.bean.IdNumBean;
import com.aohuan.dodo.rx.retrofit.hello.net.ApiHelper;
import com.aohuan.dodo.rx.retrofit.utils.RetrofitHelper;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import retrofit2.Retrofit;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;

public class R1Activity extends AppCompatActivity {

    @InjectView(R.id.btn1)
    Button btn1;
    @InjectView(R.id.tv1)
    TextView tv1;
    @InjectView(R.id.et1)
    EditText et1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_r1);
        ButterKnife.inject(this);
    }

    @OnClick({R.id.btn1, R.id.tv1, R.id.et1})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn1:
                if (et1.getText().toString().length() != 18) {
                    ToastUtils.show(this, "请填写18位身份证号码！！");
                    return;
                }
                JuHeService js = RetrofitHelper.getTbyJson(JuHeService.class, ApiHelper.juhe_mobile_num);
//                Observable<IdNumBean> inb = js.getActivityCenterList(et1.getText().toString());
                Observable<IdNumBean> inb = js.getNumInfo();
                inb.observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Action1<IdNumBean>() {
                            @Override
                            public void call(IdNumBean idNumBean) {
                                tv1.setText(idNumBean.getResult().getProvince() + " city: " + idNumBean.getResult().getCity());
                            }
                        });
                break;
        }
    }
}
