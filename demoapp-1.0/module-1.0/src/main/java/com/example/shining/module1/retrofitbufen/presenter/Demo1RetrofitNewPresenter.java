package com.example.shining.module1.retrofitbufen.presenter;

import com.example.shining.libmvp.mvp.Presenter;
import com.example.shining.libretrofit.RetrofitNetNew;
import com.example.shining.module1.retrofitbufen.api.ApiDemo1RetrofitNew;
import com.example.shining.module1.retrofitbufen.bean.DemoNewModel;
import com.example.shining.module1.retrofitbufen.view.DemoRetrofitNewView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Demo1RetrofitNewPresenter extends Presenter<DemoRetrofitNewView> {

    public void get_hr_demo1(String type, String key) {
        RetrofitNetNew.build(ApiDemo1RetrofitNew.class, getIdentifier()).get_request_post(type, key).enqueue(new Callback<DemoNewModel>() {
            @Override
            public void onResponse(Call<DemoNewModel> call, Response<DemoNewModel> response) {
                if (getView() == null) {
                    return;
                }
                DemoNewModel detectResult = response.body();
                if (detectResult != null) {
                    getView().Success(detectResult);
                } else {
                    getView().Failed(response.message());
                }
                call.cancel();

            }

            @Override
            public void onFailure(Call<DemoNewModel> call, Throwable t) {
                if (getView() == null) {
                    return;
                }
                getView().Failed(t.getMessage());

                call.cancel();
            }
        });
    }
}
