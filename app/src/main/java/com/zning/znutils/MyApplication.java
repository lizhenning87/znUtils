package com.zning.znutils;

import android.app.Application;

import com.uesugi.library.utils.Utils;

/**
 * Created by lizhenning on 2017/9/27.
 */

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Utils.setUrl_base("http://www.baidu.com");


    }
}
