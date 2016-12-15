package com.aohuan.dodo.rx.retrofit.utils;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by dodo_lihao on 2016/12/9.
 * qq: 2390183798
 */
public class RetrofitHelper {

    private static OkHttpClient mOkHttpClient;  //OkHttpClient

    {
        mOkHttpClient = OkHttpHelper.initOkHttpClient(mOkHttpClient);
    }

    public static OkHttpClient getmOkHttpClient(){
        if(mOkHttpClient == null){
            mOkHttpClient = OkHttpHelper.initOkHttpClient(mOkHttpClient);
        }
        return mOkHttpClient;
    }


    public static <T> T getTbyJson(Class<T> clazz, String URL) {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URL)
                .client(getmOkHttpClient())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();

        return retrofit.create(clazz);
    }


}
