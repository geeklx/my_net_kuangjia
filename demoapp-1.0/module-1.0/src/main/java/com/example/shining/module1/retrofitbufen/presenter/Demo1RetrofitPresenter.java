package com.example.shining.module1.retrofitbufen.presenter;

import android.util.Log;

import com.example.shining.libmvp.mvp.Presenter;
import com.example.shining.libretrofit.RetrofitNet;
import com.example.shining.module1.retrofitbufen.api.ApiDemo1Retrofit;
import com.example.shining.module1.retrofitbufen.bean.DetectResult;
import com.example.shining.module1.retrofitbufen.bean.FaceAddResult;
import com.example.shining.module1.retrofitbufen.bean.SearchResult;
import com.example.shining.module1.retrofitbufen.view.Demo1RetrofitView;

import java.io.File;
import java.util.List;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Demo1RetrofitPresenter extends Presenter<Demo1RetrofitView> {

    public void detect(String api_key, String api_secret, String image_base64, final int which) {

        RetrofitNet.build(ApiDemo1Retrofit.class).faceDetect(api_key, api_secret, image_base64).enqueue(new Callback<DetectResult>() {
            @Override
            public void onResponse(Call<DetectResult> call, Response<DetectResult> response) {
                if(getView()==null){
                    return;
                }
                DetectResult detectResult = response.body();
                if (detectResult != null) {
                    getView().detectSuccess(getFaceToken(detectResult), which);
                } else {
                    getView().detectFailed("限制了稍等会");
                }

                call.cancel();
            }

            @Override
            public void onFailure(Call<DetectResult> call, Throwable t) {
                if(getView()==null){
                    return;
                }
                getView().detectFailed(t.getMessage());

                call.cancel();
            }
        });
    }


    public void faceAdd(String api_key, String api_secret, String outer_id, String tokens) {

        RetrofitNet.build(ApiDemo1Retrofit.class).faceAdd(api_key, api_secret, outer_id, tokens).enqueue(new Callback<FaceAddResult>() {
            @Override
            public void onResponse(Call<FaceAddResult> call, Response<FaceAddResult> response) {
                if(getView()==null){
                    return;
                }
                FaceAddResult faceAddResult = response.body();
                if (faceAddResult != null) {
                    getView().faceAddSuccess();
                } else {
                    getView().detectFailed("限制了稍等会");
                }
            }

            @Override
            public void onFailure(Call<FaceAddResult> call, Throwable t) {
                if(getView()==null){
                    return;
                }
                getView().detectFailed(t.getMessage());
            }
        });
    }


    public void faceSearch(String api_key, String api_secret, String outer_id, String token) {

        RetrofitNet.build(ApiDemo1Retrofit.class).faceSearch(api_key, api_secret, outer_id, token).enqueue(new Callback<SearchResult>() {
            @Override
            public void onResponse(Call<SearchResult> call, Response<SearchResult> response) {
                if(getView()==null){
                    return;
                }
                SearchResult searchResult = response.body();
                if (searchResult != null) {
                    getView().faceSearchSuccess(searchResult.getResults().get(0).getConfidence());
                } else {
                    getView().faceSerchFailed("限制了稍等会");
                }
            }

            @Override
            public void onFailure(Call<SearchResult> call, Throwable t) {
                if(getView()==null){
                    return;
                }
                getView().faceSerchFailed(t.getMessage());
            }
        });
    }


    public void faseDetectPart(String api_key, String api_secret, File file, final int which){
        RequestBody requestApiKey = RequestBody.create(MediaType.parse("multipart/form-data"), api_key);
        RequestBody requestApiSecret = RequestBody.create(MediaType.parse("multipart/form-data"), api_secret);
//        RequestBody requestApiAttribute = RequestBody.create(MediaType.parse("multipart/form-data"), attribute);
        RequestBody requestImgFile = RequestBody.create(MediaType.parse("multipart/form-data"), file);
        MultipartBody.Part requestImgPart =
                MultipartBody.Part.createFormData("image_file", file.getName(), requestImgFile);

        RetrofitNet.build(ApiDemo1Retrofit.class).faceDetectPart(requestApiKey,requestApiSecret,requestImgPart).enqueue(new Callback<DetectResult>() {
            @Override
            public void onResponse(Call<DetectResult> call, Response<DetectResult> response) {
                if(getView()==null){
                    return;
                }
                DetectResult detectResult = response.body();
                if (detectResult != null) {
                    getView().faceDetectPartSuccess(getFaceToken(detectResult), which);
                } else {
                    getView().detectFailed("限制了稍等会");
                }
            }

            @Override
            public void onFailure(Call<DetectResult> call, Throwable t) {
                if(getView()==null){
                    return;
                }
                getView().detectFailed(t.getMessage());

            }
        });
    }


    private String getFaceToken(DetectResult detectResult) {
        String tokens = "";
        List<DetectResult.FacesBean> facesBean = detectResult.getFaces();
        for (int i = 0; i < facesBean.size(); i++) {
            if (i != facesBean.size() - 1) {
                tokens += (facesBean.get(i).getFace_token() + ",");
            } else {
                tokens += (facesBean.get(i).getFace_token());
            }
        }
        Log.d("tokens:::", "tokens::: " + tokens);
        return tokens;
    }
}
