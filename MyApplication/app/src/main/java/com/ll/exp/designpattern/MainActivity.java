package com.ll.exp.designpattern;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.ll.exp.designpattern.builder.FHttpCallback;
import com.ll.exp.designpattern.builder.FHttpManager;
import com.ll.exp.designpattern.builder.GetOrderListRequest;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity
{
    private static TextView sTextView;
    @Bind(R.id.text) TextView mText;

    @Override protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        sTextView = mText;
    }

    @OnClick(R.id.text) public void onClick()
    {
        Intent intent = new Intent();
        intent.setClass(this, TestActivity.class);
        startActivity(intent);

        finish();

        GetOrderListRequest getOrderListRequest = new GetOrderListRequest.ParamsBuilder().build();
        FHttpManager.getInstance().asyncExecute(getOrderListRequest, new FHttpCallback()
        {
            @Override public void onSuccess(String response)
            {
                super.onSuccess(response);
            }
        });
    }
}
