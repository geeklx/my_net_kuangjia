package com.example.shining.appdemo1;

import android.content.Context;
import android.os.Environment;
import android.support.multidex.MultiDex;
import android.support.multidex.MultiDexApplication;

import com.example.shining.appdemo1.glinsetting.Appdemo1ResultInterceptor;
import com.example.shining.libglide37.glide.GlideOptionsFactory;
import com.example.shining.libglin.glin.interceptor.IResultInterceptor;
import com.example.shining.libglin.juhenet.JuheNet;
import com.example.shining.libglin.net.Net;
import com.example.shining.libretrofit.RetrofitNetNew;
import com.example.shining.libutils.utilslib.app.MyLogUtil;


/**
 * Created by shining on 2017/8/31.
 */

public class Appdemo1Application extends MultiDexApplication {

    public static final String DIR_PROJECT = "/geek/appdemo1/";
    public static final String DIR_CACHE = DIR_PROJECT + "cache/"; // 网页缓存路径

    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }

    @Override
    public void onCreate() {
        super.onCreate();

        GlideOptionsFactory.init(this, R.drawable.ic_def_loading);
        configNet(true, new Appdemo1ResultInterceptor());
        configJuheNet(true, new Appdemo1ResultInterceptor());

        configRetrofitNet();
    }

    protected void configNet(boolean debug, IResultInterceptor interceptor) {
        String cacheDir = Environment.getExternalStorageDirectory() + DIR_CACHE;

        new Net.Builder()
                .baseUrl("")
                .debug(debug)
                .timeout(5 * 1000)
                .cacheDir(cacheDir)
                .cacheSize(1024 * 1024)
                .resultInterceptor(interceptor)
                .build();
    }

    protected void configJuheNet(boolean debug, IResultInterceptor interceptor) {
        String cacheDir = Environment.getExternalStorageDirectory() + DIR_CACHE;

        new JuheNet.Builder()
                .baseUrl("")
                .debug(debug)
                .timeout(5 * 1000)
                .cacheDir(cacheDir)
                .cacheSize(1024 * 1024)
                .resultInterceptor(interceptor)
                .build();
    }

    protected void configRetrofitNet() {
        String cacheDir = Environment.getExternalStorageDirectory() + DIR_CACHE;
        // https://api-cn.faceplusplus.com/
//        RetrofitNet.config();
        MyLogUtil.on(true);
        RetrofitNetNew.config();
    }

}
