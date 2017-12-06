package com.example.shining.libretrofit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by shining on 2017/9/5.
 */

public class RetrofitNet {
    private static RetrofitNet sInstance;

    private Retrofit retrofit;
    private OkHttpClient client;

    public Retrofit init() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
//        builder.addInterceptor(new HeaderInterceptor())//使用自定义的Header拦截器
        builder.addInterceptor(new LoggingInterceptor());//使用自定义的Log拦截器
        client = builder.build();
//        client.dispatcher().runningCalls().get(0).request().tag()

        retrofit = new Retrofit.Builder()
                .baseUrl("https://www.baidu.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();

        return retrofit;

    }

    private RetrofitNet() {
        init();
    }

    public static void config() {
        sInstance = new RetrofitNet();
    }

    public static RetrofitNet getInstance() {
        return sInstance;
    }

    public Retrofit get() {
        return retrofit;
    }


    public void cancelAll() {
        client.dispatcher().cancelAll();

    }


    /**
     * 创建一个业务请求 <br />
     *
     * @param convertClass 业务请求接口的class
     * @return
     */
//    public static <T> T build(Class<T> convertClass, Object tag) {
    public static <T> T build(Class<T> convertClass) {
        return getInstance().get().create(convertClass);
    }

}
