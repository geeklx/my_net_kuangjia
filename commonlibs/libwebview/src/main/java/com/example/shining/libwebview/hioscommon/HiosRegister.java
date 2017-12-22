package com.example.shining.libwebview.hioscommon;

import com.example.shining.libwebview.hois2.HiosAlias;

public class HiosRegister {

    private static final String PKG_SFNATION = "com.example.shining.libwebview";

    public static void load() {

        HiosAlias.register("jump.HiosMainActivity", PKG_SFNATION, ".activity.HiosMainActivity");
//        HiosAlias.register("jump.webviewmainactivity", PKG_SFNATION, ".base.WebViewMainActivity");

    }
}
