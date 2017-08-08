package com.kyle.demo;

import android.app.Application;

import com.kyle.demo.utils.CrashHandler;

/**
 * Created by Kyle on 2017/8/8 0008.
 */

public class LogDemoApplication extends Application {
    private static LogDemoApplication sInstance = null;

    @Override
    public void onCreate() {
        super.onCreate();
        sInstance = this;

        CrashHandler.getInstance().init(this);
    }

    public static LogDemoApplication getInstance() {
        return sInstance;
    }
}
