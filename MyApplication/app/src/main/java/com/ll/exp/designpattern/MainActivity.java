package com.ll.exp.designpattern;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends Activity
{
    String mString = "asd（asdfasd)sdf";
    @Bind(R.id.text1) TextView mText;

    @Override protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.text1) public void onClick()
    {
        changeText(mString, mText);
    }

    private void changeText(String text, TextView textView)
    {
        int en_left = text.indexOf("(");
        int en_right = text.indexOf(")");
        int ch_left = text.indexOf("（");
        int ch_right = text.indexOf("）");
        int left = -1;
        int right = -1;
        if (-1 != en_left)
        {
            left = en_left;
        }
        else
        {
            if (-1 != ch_left)
            {
                left = ch_left;
            }
        }
        if (-1 != en_right)
        {
            right = en_right;
        }
        else
        {
            if (-1 != ch_right)
            {
                right = ch_right;
            }
        }
        if (-1 != left && -1 != right && left < right)
        {
            Spannable span = new SpannableString(text);
            span.setSpan(new ForegroundColorSpan(Color.MAGENTA), left, right + 1,
                    Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            span.setSpan(new AbsoluteSizeSpan(20, true), left, right + 1,
                    Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            textView.setText(span);
        }
        else
        {
            textView.setText(text);
        }
    }
}
