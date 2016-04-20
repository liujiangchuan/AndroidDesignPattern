package com.ll.exp.designpattern;

import android.app.Application;

/**
 * Created by User on 2016/4/18.
 */
public class myApp extends Application
{
    @Override public void onCreate()
    {
        super.onCreate();
        //        LeakCanary.install(this);
    }
}
