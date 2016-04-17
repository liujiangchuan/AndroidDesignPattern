package com.ll.exp.designpattern.builder.httpbuilder;

import java.util.HashMap;
import java.util.Map;

import okhttp3.Request;

/**
 * Created by User on 2016/4/17.
 */
public abstract class FHttpRequestBuilder
{
    private final String COMMON_PARAMS_TOKEN = "token";
    protected Object mTag;
    protected String mUrl;
    protected Map<String, String> mParams;

    public abstract Request build();

    Map<String, String> addCommonUrlParams()
    {
        return addCommonUrlParams(null);
    }

    Map<String, String> addCommonUrlParams(Map<String, String> params)
    {
        if (null == params)
        {
            params = new HashMap<>();
        }
        params.put(COMMON_PARAMS_TOKEN, "aa");
        return params;
    }

    protected String appendUrlParams(String url, Map<String, String> params)
    {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(url + "?");
        if (null != params && !params.isEmpty())
        {
            for (String key : params.keySet())
            {
                stringBuilder.append(key).append("=").append(params.get(key)).append("&");
            }
        }
        stringBuilder = stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        return stringBuilder.toString();
    }
}
