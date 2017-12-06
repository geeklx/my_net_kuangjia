package com.example.shining.baselibrary.qcode;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;

import com.example.shining.libutils.utilslib.data.BitmapUtils;

/**
 * Created by shining on 2017/12/6.
 */

public class MohuReUtil {

    /**
     * 设置背景模糊bufen
     *
     * @param activity 在哪一个Activity上面
     * @param view     哪一个view模糊
     */
    public static void set_muhu_re(Activity activity, View view) {
        Bitmap shot = BitmapUtils.takeScreenShot(activity.getWindow().getDecorView());
        Bitmap blur = BitmapUtils.blur(activity, shot);
        view.setBackground(new BitmapDrawable(activity.getResources(), blur));
//        view.setBackgroundDrawable(new BitmapDrawable(activity.getResources(), blur));
    }
}
