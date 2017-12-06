package com.example.shining.module1.glinbufen.view;


import com.example.shining.module1.glinbufen.bean.glinjuhe.DemoJuheFileModel;
import com.example.shining.module1.glinbufen.bean.glinjuhe.DemoJuheModel;
import com.example.shining.module1.glinbufen.glinmvp.GlinIView;

public interface Demo1JuheView extends GlinIView {
    void onGetDemo1JuheSuccess(DemoJuheModel data);

    void onGetDemo1JuheEmpty(DemoJuheModel data);

    void onGetDemo1JuheFailed(String msg);


    void onGetDemo1JuheFlieSuccess(DemoJuheFileModel data);

    void onGetDemo1JuheFlieEmpty(DemoJuheFileModel data);

    void onGetDemo1JuheFlieFailed(String msg);

}
