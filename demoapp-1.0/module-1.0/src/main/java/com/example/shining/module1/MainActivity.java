package com.example.shining.module1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.shining.baselibrary.smartbar.IBaseAction;
import com.example.shining.baselibrary.smartbar.SmartBar;
import com.example.shining.baselibrary.smartbar.SmartBarInject;
import com.example.shining.module1.activity.DemoMainActivity;
import com.example.shining.module1.activity.DemoRetrofitActivity;

/**
 * Created by shining on 2017/12/1.
 */

public class MainActivity extends AppCompatActivity implements IBaseAction {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SmartBarInject.inject(this).show(SmartBar.HOME | SmartBar.BACK);


        findViewById(R.id.tv1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, DemoMainActivity.class));
            }
        });

        findViewById(R.id.tv3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, DemoRetrofitActivity.class));
            }
        });
    }

    @Override
    public void onHomePressed() {
        finish();
    }

    @Override
    public Activity who() {
        return this;
    }
}
