package com.example.shining.module1.activity;

import android.content.Context;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.view.LayoutInflaterCompat;
import android.support.v4.view.LayoutInflaterFactory;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.shining.baselibrary.toasts.ToastUtil;
import com.example.shining.libglide37.glide.GlideOptions;
import com.example.shining.libglide37.glide.GlideUtil;
import com.example.shining.libutils.utilslib.app.MyLogUtil;
import com.example.shining.libutils.utilslib.device.DeviceUtil;
import com.example.shining.module1.R;
import com.example.shining.module1.glinbufen.bean.glinjuhe.DemoJuheFileModel;
import com.example.shining.module1.glinbufen.bean.glinjuhe.DemoJuheModel;
import com.example.shining.module1.glinbufen.bean.glinnet.Demo1Model;
import com.example.shining.module1.glinbufen.presenter.Demo1GlinPresenter;
import com.example.shining.module1.glinbufen.presenter.Demo1JuhePresenter;
import com.example.shining.module1.glinbufen.view.Demo1JuheView;
import com.example.shining.module1.glinbufen.view.Demo1View;
import com.example.shining.module1.retrofitbufen.presenter.Demo1RetrofitPresenter;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

public class DemoMainActivity extends AppCompatActivity implements Demo1View, Demo1JuheView {

    private ImageView iv1;

    //glin
    private Demo1GlinPresenter mDemo1Presenter = new Demo1GlinPresenter();
    //juhe glin
    private Demo1JuhePresenter mDemo1JuhePresenter = new Demo1JuhePresenter();
    //retrofit
    private Demo1RetrofitPresenter mDemo1RetrofitPresenter = new Demo1RetrofitPresenter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        interceptCreateView();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_glin);
        iv1 = (ImageView) findViewById(R.id.iv1);
        iv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastUtil.showToastLong("test!!!");
            }
        });
        //TODO test glide
        GlideOptions glideOptions = new GlideOptions(R.drawable.ic_def_loading, R.drawable.ic_def_loading, 300);
//        GlideUtil.display(MainActivity.this, iv1, ratings.getImg_url(), GlideOptionsFactory.get(GlideOptionsFactory.Type.RADIUS));
        GlideUtil.display(DemoMainActivity.this, iv1, "http://s3.51cto.com/wyfs02/M02/8B/22/wKiom1hFLyKTGPwiAACdgfAvtXo683.jpg", glideOptions);//

        //TODO test util
        MyLogUtil.d("test util");

        //TODO test Glin
        mDemo1Presenter.onCreate(DemoMainActivity.this);
        mDemo1Presenter.getDemo1Presenter("user_id");

        //TODO test JuheGlin
        mDemo1JuhePresenter.onCreate(this);
        mDemo1JuhePresenter.getDemo1JuhePresenter("shehui", "03972d8ebd2a40194a80fa019b314fa3");

        // 内置sd卡路径
        try {
            saveToSDCard("menling.mp3");
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        String sdcardPath2 = Environment.getExternalStorageDirectory().getAbsolutePath() + "/menling.mp3";
        // apk目录
//        String sdcardPath2 = "android.resource://" + App.get().getPackageName() + "/" + R.raw.menling;
        File file = new File(sdcardPath2);
        String rate = "16000";
        String pname = DemoMainActivity.this.getPackageName();
        String device_id = DeviceUtil.getMac(this);
        String key = "76fe50b78862b2450ee9f24c8622fd3f";
        mDemo1JuhePresenter.getDemo1JuheFilePresenter(file, rate, pname, device_id, key);

        //TODO test Retrofit

    }

    public void saveToSDCard(String name) throws Throwable {
        InputStream inStream = getResources().openRawResource(R.raw.menling);
        File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath(), name);
        FileOutputStream fileOutputStream = new FileOutputStream(file);//存入SDCard
        byte[] buffer = new byte[10];
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        int len = 0;
        while ((len = inStream.read(buffer)) != -1) {
            outStream.write(buffer, 0, len);
        }
        byte[] bs = outStream.toByteArray();
        fileOutputStream.write(bs);
        outStream.close();
        inStream.close();
        fileOutputStream.flush();
        fileOutputStream.close();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    @Override
    protected void onPause() {
        super.onPause();

    }

    @Override
    protected void onDestroy() {
        mDemo1Presenter.onDestory();
        mDemo1JuhePresenter.onDestory();
        super.onDestroy();
    }

    private void interceptCreateView() {
        LayoutInflaterCompat.setFactory(LayoutInflater.from(this), new LayoutInflaterFactory() {
            @Override
            public View onCreateView(View parent, String name, Context context, AttributeSet attrs) {
                AppCompatDelegate delegate = getDelegate();
                View view = delegate.createView(parent, name, context, attrs);
                if (view != null && view instanceof EditText) {
                    MyLogUtil.d("***", "IME_FLAG_NO_EXTRACT_UI");
                    EditText et = (EditText) view;
                    et.setImeOptions(et.getImeOptions() | EditorInfo.IME_FLAG_NO_EXTRACT_UI);
                    return et;
                }
                return view;
            }
        });
    }


    @Override
    public void onGetNewMyWalletShoppingCardListSuccess(Demo1Model data) {
        Demo1Model demo1Model = data;

    }

    @Override
    public void onGetNewMyWalletShoppingCardListEmpty(Demo1Model data) {
        Demo1Model demo1Model = data;
    }

    @Override
    public void onGetNewMyWalletShoppingCardListFailed(String msg) {
        ToastUtil.showToastLong(msg);
    }

    private long mCurrentMs = System.currentTimeMillis();

    @Override
    public String getIdentifier() {
        return this.getClass().getName() + this.mCurrentMs;
    }


    @Override
    public void onGetDemo1JuheSuccess(DemoJuheModel data) {
        DemoJuheModel demoJuheModel = data;
    }

    @Override
    public void onGetDemo1JuheEmpty(DemoJuheModel data) {
        DemoJuheModel demoJuheModel = data;
    }

    @Override
    public void onGetDemo1JuheFailed(String msg) {
        ToastUtil.showToastLong(msg);
    }


    @Override
    public void onGetDemo1JuheFlieSuccess(DemoJuheFileModel data) {
        DemoJuheFileModel demoJuheFileModel = data;
    }

    @Override
    public void onGetDemo1JuheFlieEmpty(DemoJuheFileModel data) {
        DemoJuheFileModel demoJuheFileModel = data;
    }

    @Override
    public void onGetDemo1JuheFlieFailed(String msg) {
        ToastUtil.showToastLong(msg);
    }
}
