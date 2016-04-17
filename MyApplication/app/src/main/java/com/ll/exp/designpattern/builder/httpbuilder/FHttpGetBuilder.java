package com.ll.exp.designpattern.builder.httpbuilder;

import java.util.Map;

import okhttp3.Request;

/**
 * Created by User on 2016/4/17.
 */
public class FHttpGetBuilder extends FHttpRequestBuilder
{
    public FHttpGetBuilder(Object tag, String url, Map<String, String> params)
    {
        mTag = tag;
        mUrl = url;
        mParams = params;
    }

    @Override public Request build()
    {
        String url = appendUrlParams(mUrl, addCommonUrlParams(mParams));
        return new Request.Builder().tag(mTag).url(url).build();
    }
}
