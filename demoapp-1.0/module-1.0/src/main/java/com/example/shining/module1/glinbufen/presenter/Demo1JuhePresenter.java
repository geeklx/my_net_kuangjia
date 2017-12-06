package com.example.shining.module1.glinbufen.presenter;

import com.example.shining.libglin.glin.Callback;
import com.example.shining.libglin.glin.Result;
import com.example.shining.libglin.juhenet.JuheNet;
import com.example.shining.module1.glinbufen.api.ApiDemo1;
import com.example.shining.module1.glinbufen.bean.glinjuhe.DemoJuheFileModel;
import com.example.shining.module1.glinbufen.bean.glinjuhe.DemoJuheModel;
import com.example.shining.module1.glinbufen.glinmvp.GlinPresenter;
import com.example.shining.module1.glinbufen.view.Demo1JuheView;

import java.io.File;

/**
 * Created by shining on 2017/9/5.
 */

public class Demo1JuhePresenter extends GlinPresenter<Demo1JuheView> {

    /**
     * 直接根据地质拼接键值对解析的请求方式
     */
    public void getDemo1JuhePresenter(String type, String key) {
        JuheNet.build(ApiDemo1.class, getIdentifier()).getList(type, key).enqueue(new Callback<DemoJuheModel>() {
            @Override
            public void onResponse(Result<DemoJuheModel> result) {
                if (!hasView()) {
                    return;
                }
                if (!result.isOK()) {
                    getView().onGetDemo1JuheFailed(result.getMessage());
                    return;
                }
                DemoJuheModel data = result.getResult();
                if (data == null) {
                    //暂无数据bufen
                    getView().onGetDemo1JuheEmpty(data);
                    return;
                }
                //请求成功bufen
                getView().onGetDemo1JuheSuccess(data);

            }
        });
    }

    /**
     * 直接根据地质拼接键值对解析的请求方式
     */
    public void getDemo1JuheFilePresenter(File file, String rate, String pname, String device_id, String key) {
        JuheNet.build(ApiDemo1.class, getIdentifier()).getfile(file, rate, pname, device_id, key).enqueue(new Callback<DemoJuheFileModel>() {
            @Override
            public void onResponse(Result<DemoJuheFileModel> result) {
                if (!hasView()) {
                    return;
                }
                if (!result.isOK()) {
                    getView().onGetDemo1JuheFlieFailed(result.getMessage());
                    return;
                }
                DemoJuheFileModel data = result.getResult();
                if (data == null) {
                    //暂无数据bufen
                    getView().onGetDemo1JuheFlieEmpty(data);
                    return;
                }
                //请求成功bufen
                getView().onGetDemo1JuheFlieSuccess(data);
            }
        });
    }
}
