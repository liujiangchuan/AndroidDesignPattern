package com.ll.exp.designpattern;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.ll.exp.designpattern.builder.FHttpCallback;
import com.ll.exp.designpattern.builder.FHttpManager;
import com.ll.exp.designpattern.builder.GetOrderListRequest;

public class MainActivity extends AppCompatActivity
{
    TextView mTextView;

    @Override protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextView = (TextView) findViewById(R.id.text);
        mTextView.setOnClickListener(new View.OnClickListener()
        {
            @Override public void onClick(View v)
            {
                GetOrderListRequest getOrderListRequest =
                        new GetOrderListRequest.ParamsBuilder().build();
                FHttpManager.getInstance().asyncExecute(getOrderListRequest, new FHttpCallback()
                {
                    @Override public void onSuccess(String response)
                    {
                        super.onSuccess(response);
                    }
                });
            }
        });

    }
}
