package com.example.shining.biz_demo1.view;


import com.example.shining.biz_demo1.bean.Huoquhaoyou;
import com.example.shining.libmvp.mvp.IView;

import java.util.List;

public interface IHaoyouView extends IView {
    void onHaoyouError(String msg);
    void onHaoyouSuccess(List<Huoquhaoyou> results);
}
