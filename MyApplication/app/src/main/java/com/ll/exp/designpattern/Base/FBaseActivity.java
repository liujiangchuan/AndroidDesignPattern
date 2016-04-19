package com.ll.exp.designpattern.Base;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.util.Log;

import butterknife.ButterKnife;

/**
 * Created by User on 2016/4/19.
 */
public abstract class FBaseActivity extends FragmentActivity
{
    public static Handler sUIHandler = new Handler(Looper.getMainLooper());

    @Override protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(savedInstanceState);
        ButterKnife.bind(this);
        init();
        Log.i("liujc", "onCreate");
    }

    @Override protected void onStart()
    {
        super.onStart();
        Log.i("liujc", "onStart");
    }

    @Override protected void onResume()
    {
        super.onResume();
        Log.i("liujc", "onResume");
    }

    @Override protected void onPause()
    {
        super.onPause();
        Log.i("liujc", "onPause");
    }

    @Override protected void onStop()
    {
        super.onStop();
        Log.i("liujc", "onStop");
    }

    @Override protected void onDestroy()
    {
        super.onDestroy();
        Log.i("liujc", "onDestroy");
    }

    @Override public void setContentView(int layoutResID)
    {
        super.setContentView(layoutResID);
    }


    /**
     * invoke setContentView().
     *
     * @param savedInstanceState
     */
    protected abstract void setContentView(Bundle savedInstanceState);

    protected abstract void init();

    protected abstract void reloadData();
}
