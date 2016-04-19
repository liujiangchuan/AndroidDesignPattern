package com.ll.exp.designpattern;

import android.os.Bundle;

import com.ll.exp.designpattern.Base.FBaseActivity;

/**
 * Created by User on 2016/4/18.
 */
public class TestActivity extends FBaseActivity
{
    @Override protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
    }

    @Override protected void setContentView(Bundle savedInstanceState)
    {
        setContentView(R.layout.activity_main);
    }

    @Override protected void init()
    {

    }

    @Override protected void reloadData()
    {

    }
}
