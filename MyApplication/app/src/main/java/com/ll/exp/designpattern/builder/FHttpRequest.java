package com.ll.exp.designpattern.builder;

import com.ll.exp.designpattern.builder.httpbuilder.FHttpRequestBuilder;

/**
 * Created by User on 2016/4/15.
 */
public abstract class FHttpRequest
{
    Object getTag()
    {
        return getUrl().hashCode();
    }

    abstract String getUrl();

    abstract FHttpRequestBuilder getRequestBuilder();
}
