package com.example.shining.module1.retrofitbufen.view;


import com.example.shining.libmvp.mvp.IView;
import com.example.shining.module1.retrofitbufen.bean.DemoNewModel;

public interface DemoRetrofitNewView extends IView {
    void Success(DemoNewModel tokens);

    void Failed(String msg);
}
