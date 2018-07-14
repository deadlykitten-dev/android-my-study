package com.kestrel9.android.mystudy;

import android.app.Application;

/**
 * Mystudy
 * Class: MyApplication
 * Created by kestr on 2018-07-14.
 * <p>
 * Description:
 */
public class MyApplication extends Application {

    private static MyApplication _instance;

    @Override
    public void onCreate() {
        super.onCreate();

        _instance = this;
    }

    public static MyApplication getInstance(){
        return _instance;
    }
}
