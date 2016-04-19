package com.ll.exp.designpattern;

import android.content.Context;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.ll.exp.designpattern.Base.FBaseActivity;
import com.ll.exp.designpattern.builder.FHttpCallback;
import com.ll.exp.designpattern.builder.FHttpManager;
import com.ll.exp.designpattern.builder.GetOrderListRequest;

import butterknife.Bind;
import butterknife.OnClick;

public class MainActivity extends FBaseActivity
{
    private static TextView sTextView;
    private Context mContext;
    @Bind(R.id.text) TextView mText;

    @Override protected void setContentView(Bundle savedInstanceState)
    {
        setContentView(R.layout.activity_main);
    }

    @Override protected void init()
    {
        sTextView = mText;
        mContext = this;
        reloadData();
    }

    @Override protected void reloadData()
    {

    }

    @OnClick(R.id.text) public void onClick()
    {
        GetOrderListRequest getOrderListRequest = new GetOrderListRequest.ParamsBuilder().build();
        FHttpManager.getInstance().asyncExecute(getOrderListRequest, new FHttpCallback()
        {
            @Override public void onSuccess(String response)
            {
                super.onSuccess(response);
                Toast.makeText(mContext, "aa", Toast.LENGTH_LONG).show();
            }
        });
    }
}
