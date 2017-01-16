package com.aohuan.dodo.dispatchevent_about.dummy_demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.aohuan.dodo.dispatchevent_about.R;

public class D01Activity extends AppCompatActivity {

    WebView mWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_d01);

        mWebView = (WebView) findViewById(R.id.webv);
//        mWebView.loadUrl("http://baidu.com");
        mWebView.loadUrl("http://www.jianshu.com/");

        mWebView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });
        mWebView.getSettings().setJavaScriptEnabled(true);

    }
}
