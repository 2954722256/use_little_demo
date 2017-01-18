package com.aohuan.dodo.request.okhttp;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.aohuan.dodo.common.utils.base.ABaseAutoActivity;
import com.aohuan.dodo.common.utils.base.AhView;
import com.aohuan.dodo.request.R;
import com.aohuan.dodo.request.utils.Contants;
import com.aohuan.dodo.request.utils.bean.Day13Bean;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import java.io.IOException;
import butterknife.InjectView;
import butterknife.OnClick;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

@AhView(R.layout.okhttp_activity_o01)
public class O01Activity extends ABaseAutoActivity {

    @InjectView(R.id.request)
    Button request;
    @InjectView(R.id.tv_show)
    TextView tvShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        tvShow.setMovementMethod(ScrollingMovementMethod.getInstance());
        init();
    }

    private void init() {
        request1();
    }

    OkHttpClient client = new OkHttpClient();
    public static final MediaType JSON
            = MediaType.parse("application/json; charset=utf-8");

    private void request1() {
        try {
            post(Contants.URL_BLIBLI_DAY_113, Day13Bean.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private final Gson gson = new Gson();

    public <T> void post(String url, final Class<T> cls) throws Exception {
        Request request = new Request.Builder()
                .url(url)
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);

                Headers responseHeaders = response.headers();
                for (int i = 0; i < responseHeaders.size(); i++) {
                    System.out.println(responseHeaders.name(i) + ": " + responseHeaders.value(i));
                }
                String str = ascii2native(response.body().string());
                Log.e("repo", "resp2: " + str);

//                tvShow.setText(str);
                Message msg = mHandler.obtainMessage();
                msg.what = 1;
                msg.obj = str;
                mHandler.sendMessage(msg);

                try {
                    T d13 = gson.fromJson(str, cls);
//                    Log.e("bean", "bean: " + d13.toString());
                } catch (JsonSyntaxException e) {
                    e.printStackTrace();
                }
            }
        });
    }


    Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            tvShow.setText(msg.obj.toString());
        }
    };


    @OnClick({R.id.request})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.request:
                request1();
                break;
        }
    }


    public String ascii2native(String utfString) {
        StringBuilder sb = new StringBuilder();
        int i = -1;
        int pos = 0;

        while ((i = utfString.indexOf("\\u", pos)) != -1) {
            sb.append(utfString.substring(pos, i));
            if (i + 5 < utfString.length()) {
                pos = i + 6;
                sb.append((char) Integer.parseInt(utfString.substring(i + 2, i + 6), 16));
            }
        }

        return sb.toString();
    }
}
