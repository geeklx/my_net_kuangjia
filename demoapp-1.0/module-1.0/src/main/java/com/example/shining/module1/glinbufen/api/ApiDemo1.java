package com.example.shining.module1.glinbufen.api;

import com.example.shining.libglin.glin.annotation.Arg;
import com.example.shining.libglin.glin.annotation.JSON;
import com.example.shining.libglin.glin.annotation.POST;
import com.example.shining.libglin.glin.call.Call;
import com.example.shining.module1.glinbufen.bean.glinjuhe.DemoJuheFileModel;
import com.example.shining.module1.glinbufen.bean.glinjuhe.DemoJuheModel;
import com.example.shining.module1.glinbufen.bean.glinnet.Demo1Model;

import java.io.File;

/**
 * Created by shining on 2017/9/1.
 */

public interface ApiDemo1 {

    //新版我的钱包购物卡接口bufen
    @JSON("http://58.87.72.48:8888/v1/userAccount/user.account.mycard")
    Call<Demo1Model> mywallet_shoppingcard_list(String json);

    @POST("http://v.juhe.cn/toutiao/index")
    Call<DemoJuheModel> getList(@Arg("type") String type, @Arg("key") String key);

    @POST("http://japi.juhe.cn/voice_words/getWords")
    Call<DemoJuheFileModel> getfile(@Arg("file") File file, @Arg("rate") String rate, @Arg("pname") String pname, @Arg("device_id") String device_id, @Arg("key") String key);


}
