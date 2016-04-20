package com.ll.exp.designpattern.builder;

import android.text.TextUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by User on 2016/4/15.
 */
public class GetOrderListRequest
{
    /**
     * GetOrderListRequest getOrderListRequest = new GetOrderListRequest.ParamsBuilder().setP("p").build();
     */
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
}
