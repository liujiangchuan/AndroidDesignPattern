package com.ll.exp.designpattern.builder;

import android.text.TextUtils;

import com.ll.exp.designpattern.builder.httpbuilder.FHttpGetBuilder;
import com.ll.exp.designpattern.builder.httpbuilder.FHttpRequestBuilder;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by User on 2016/4/15.
 */
public class GetOrderListRequest extends FHttpRequest
{
    private final String URL = "https://github.com/hongyangAndroid";
    private final String P = "p";
    private Map<String, String> mParams;

    private GetOrderListRequest(ParamsBuilder builder)
    {
        mParams = new HashMap<>();
        String p = builder.p;
        if (!TextUtils.isEmpty(p))
        {
            mParams.put(P, builder.p);
        }
    }

    public static class ParamsBuilder
    {
        private String p;

        public ParamsBuilder setP(String p)
        {
            this.p = p;
            return this;
        }

        public GetOrderListRequest build()
        {
            return new GetOrderListRequest(this);
        }
    }

    @Override public String getUrl()
    {
        return URL;
    }

    @Override public FHttpRequestBuilder getRequestBuilder()
    {
        return new FHttpGetBuilder(getTag(), URL, mParams);
    }
}
