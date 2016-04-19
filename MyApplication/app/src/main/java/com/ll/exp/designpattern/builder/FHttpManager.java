package com.ll.exp.designpattern.builder;

import android.util.Log;

import com.ll.exp.designpattern.Base.FBaseActivity;

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
                    sendFailCallback(fHttpCallback, STATUS_ERROR, null, e);
                    showRequestLog(call, null);
                    Log.e("liujc", "asyncExecute e: " + e.getMessage());
                }

                @Override public void onResponse(Call call, Response response)
                {
                    if (null != response)
                    {
                        sendSuccessCallback(fHttpCallback, response.toString());
                        showRequestLog(call, response);
                    }
                    else
                    {
                        sendFailCallback(fHttpCallback, STATUS_ERROR, null, null);
                    }
                }
            });
        }
        catch (Exception e)
        {
            e.printStackTrace();
            sendFailCallback(fHttpCallback, STATUS_ERROR, null, e);
            Log.e("liujc", "asyncExecute e: " + e.getMessage());
        }
    }

    public void sendFailCallback(final FHttpCallback fHttpCallback, final int status,
                                 final String msg, final Exception e)
    {
        FBaseActivity.sUIHandler.post(new Runnable()
        {
            @Override public void run()
            {
                fHttpCallback.onFailure(status, msg, e);
            }
        });
    }

    public void sendSuccessCallback(final FHttpCallback fHttpCallback, final String response)
    {
        FBaseActivity.sUIHandler.post(new Runnable()
        {
            @Override public void run()
            {
                fHttpCallback.onSuccess(response);
                //// TODO: 2016/4/19  onEmpty
            }
        });
    }

    public void cancelTag(Object tag)
    {
        for (Call call : mOkHttpClient.dispatcher().queuedCalls())
        {
            if (tag.equals(call.request().tag()))
            {
                call.cancel();
            }
        }
        for (Call call : mOkHttpClient.dispatcher().runningCalls())
        {
            if (tag.equals(call.request().tag()))
            {
                call.cancel();
            }
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
