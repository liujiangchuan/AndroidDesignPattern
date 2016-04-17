package com.ll.exp.designpattern.builder;

import android.util.Log;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by User on 2016/4/17.
 */
public class FHttpManager
{
    public static final int STATUS_ERROR = -1;
    private static FHttpManager ourInstance = new FHttpManager();
    private OkHttpClient mOkHttpClient;

    public static FHttpManager getInstance()
    {
        return ourInstance;
    }

    private FHttpManager()
    {
        mOkHttpClient = new OkHttpClient();
    }

    public void asyncExecute(FHttpRequest fHttpRequest, final FHttpCallback fHttpCallback)
    {
        fHttpCallback.onPreExecute();
        try
        {
            mOkHttpClient.newCall(fHttpRequest.getRequestBuilder().build()).enqueue(new Callback()
            {
                @Override public void onFailure(Call call, IOException e)
                {
                    fHttpCallback.onFailure(STATUS_ERROR, null, e);
                    showRequestLog(call, null);
                    Log.e("liujc", "asyncExecute e: " + e.getMessage());
                }

                @Override public void onResponse(Call call, Response response)
                {
                    if (null != response)
                    {
                        fHttpCallback.onSuccess(response.toString());
                        showRequestLog(call, response);
                    }
                    else
                    {
                        fHttpCallback.onFailure(STATUS_ERROR, null, null);
                    }
                }
            });
        }
        catch (Exception e)
        {
            e.printStackTrace();
            fHttpCallback.onFailure(STATUS_ERROR, null, e);
            Log.e("liujc", "asyncExecute e: " + e.getMessage());
        }
    }

    private void showRequestLog(Call call, Response response)
    {
        if (null != call)
        {
            Request request = call.request();
            if (null != request)
            {
                Object tag = request.tag();
                HttpUrl url = request.url();
                Headers headers = request.headers();
                RequestBody body = request.body();
                if (null != tag)
                {
                    Log.i("liujc", "tag: " + tag.toString());
                }
                else
                {
                    Log.i("liujc", "tag is null!");
                }
                if (null != url)
                {
                    Log.i("liujc", "url: " + url.toString());
                }
                else
                {
                    Log.i("liujc", "url is null!");
                }
                if (null != headers)
                {
                    Log.i("liujc", "headers: " + headers.toString());
                }
                else
                {
                    Log.i("liujc", "headers is null!");
                }
                if (null != body)
                {
                    Log.i("liujc", "body: " + body.toString());
                }
                else
                {
                    Log.i("liujc", "body is null!");
                }
            }
            if (null != response)
            {
                Log.i("liujc", "response: " + response.toString());
            }
            else
            {
                Log.w("liujc", "response is null!");
            }
        }
        else
        {
            Log.e("liujc", "call is null!");
        }
    }
}
