package com.example.shining.module1.retrofitbufen.view;


import com.example.shining.libmvp.mvp.IView;

public interface Demo1RetrofitView extends IView {
    void detectSuccess(String tokens, int which);

    void detectFailed(String msg);

    void faceAddSuccess();

    void faceAddFailed(String msg);

    void faceSearchSuccess(double confidence);

    void faceSerchFailed(String msg);


    void faceDetectPartSuccess(String tokens, int which);
    void faceDetectPartFailed(String msg);


}
