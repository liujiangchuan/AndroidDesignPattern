package com.ll.exp.designpattern.builder.httpbuilder;

import java.util.Map;

import okhttp3.FormBody;
import okhttp3.Request;
import okhttp3.RequestBody;

/**
 * Created by User on 2016/4/17.
 */
public class FHttpPostBuilder extends FHttpRequestBuilder
{
    public FHttpPostBuilder(Object tag, String url, Map<String, String> params)
    {
        mTag = tag;
        mUrl = url;
        mParams = params;
    }

    @Override public Request build()
    {
        String url = appendUrlParams(mUrl, addCommonUrlParams());
        RequestBody requestBody = appendBodyParams(mParams);
        return new Request.Builder().tag(mTag).url(url).post(requestBody).build();
    }

    private RequestBody appendBodyParams(Map<String, String> params)
    {
        FormBody.Builder builder = new FormBody.Builder();
        if (null != params && !params.isEmpty())
        {
            for (String key : params.keySet())
            {
                builder.add(key, params.get(key));
            }
        }
        return builder.build();
    }
}