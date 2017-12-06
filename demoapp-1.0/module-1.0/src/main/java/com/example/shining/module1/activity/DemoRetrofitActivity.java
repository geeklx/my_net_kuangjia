package com.example.shining.module1.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;

import com.example.shining.baselibrary.baseactivitys.BaseActivity;
import com.example.shining.baselibrary.toasts.ToastUtil;
import com.example.shining.module1.R;
import com.example.shining.module1.retrofitbufen.bean.DemoNewDataModel;
import com.example.shining.module1.retrofitbufen.bean.DemoNewModel;
import com.example.shining.module1.retrofitbufen.presenter.Demo1RetrofitNewPresenter;
import com.example.shining.module1.retrofitbufen.view.DemoRetrofitNewView;

import java.util.List;

/**
 * Created by shining on 2017/12/4.
 */

public class DemoRetrofitActivity extends BaseActivity implements DemoRetrofitNewView {

    private TextView tv1;
    private Demo1RetrofitNewPresenter demo1RetrofitNewPresenter = new Demo1RetrofitNewPresenter();

    @Override
    protected void onDestroy() {
        demo1RetrofitNewPresenter.onDestory();
        super.onDestroy();
    }

    @Override
    protected void setup(@Nullable Bundle savedInstanceState) {
        super.setup(savedInstanceState);
        tv1 = findViewById(R.id.tv1);
        demo1RetrofitNewPresenter.onCreate(this);
        demo1RetrofitNewPresenter.get_hr_demo1("shehui", "03972d8ebd2a40194a80fa019b314fa3");
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main_re;
    }

    @Override
    public void Success(DemoNewModel result) {
        ToastUtil.showToastCenter("成功返回！");
        String c = "";
        List<DemoNewDataModel> aaaaa = result.getResult().getData();
        for (DemoNewDataModel b : aaaaa) {
            c += b.getTitle() + ",";
        }
        tv1.setText(c);
    }

    @Override
    public void Failed(String msg) {

    }
}
