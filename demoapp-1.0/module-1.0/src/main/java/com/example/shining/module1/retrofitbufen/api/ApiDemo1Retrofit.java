package com.example.shining.module1.retrofitbufen.api;

import com.example.shining.module1.glinbufen.bean.glinjuhe.DemoJuheModel;
import com.example.shining.module1.retrofitbufen.bean.DetectResult;
import com.example.shining.module1.retrofitbufen.bean.FaceAddResult;
import com.example.shining.module1.retrofitbufen.bean.SearchResult;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

/**
 * Created by shining on 2017/9/1.
 */

public interface ApiDemo1Retrofit {

    @Headers({
            "Content-Type: application/x-www-form-urlencoded"
//            "User-Agent: Your-App-Name"
    })
    @FormUrlEncoded
    @retrofit2.http.POST("facepp/v3/detect")
    Call<DetectResult> faceDetect(@Field("api_key") String api_key,
                                  @Field("api_secret") String api_secret,
                                  @Field("image_base64") String image_base64);

    @Headers("Content-Type: application/x-www-form-urlencoded")
    @FormUrlEncoded
    @POST("facepp/v3/faceset/addface")
    Call<FaceAddResult> faceAdd(@Field("api_key") String api_key,
                                @Field("api_secret") String api_secret,
                                @Field("outer_id") String outer_id,
                                @Field("face_tokens") String face_tokens);


    @Headers("Content-Type: application/x-www-form-urlencoded")
    @FormUrlEncoded
    @POST("facepp/v3/search")
    Call<SearchResult> faceSearch(@Field("api_key") String api_key,
                                  @Field("api_secret") String api_secret,
                                  @Field("outer_id") String outer_id,
                                  @Field("face_token") String face_token);


    @Multipart
    @POST("facepp/v3/detect")
    Call<DetectResult> faceDetectPart(@Part("api_key") RequestBody request_api_key,
                                      @Part("api_secret") RequestBody request_api_secret,
                                      @Part MultipartBody.Part request_img_part);
//            ,
//                                       @Part("attribute") RequestBody request_attribute);

    @POST("users/new")
    Call<DemoJuheModel> createUser(@Body DemoJuheModel user);


}
