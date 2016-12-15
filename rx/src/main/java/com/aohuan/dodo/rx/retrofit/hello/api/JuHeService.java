package com.aohuan.dodo.rx.retrofit.hello.api;

import com.aohuan.dodo.rx.retrofit.hello.bean.IdNumBean;

import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by dodo_lihao on 2016/12/12.
 * qq: 2390183798
 *
 *  http://apis.juhe.cn/mobile/get?phone=13429667914&key=您申请的KEY
 */
public interface JuHeService {


    @GET("get?phone={num}&key=JH4c72e95f3e69365272ea5985968099ce")
//    Observable<IdNumBean> getActivityCenterList(@Path("num") String num);
    Observable<IdNumBean> getActivityCenterList(@Query("num") String num);


    @GET("get?phone=421002198206163832&key=JH4c72e95f3e69365272ea5985968099ce")
    Observable<IdNumBean> getNumInfo();

}
