package com.ll.exp.designpattern.Base;

import com.ll.exp.designpattern.builder.FHttpCallback;
import com.ll.exp.designpattern.builder.FHttpManager;
import com.ll.exp.designpattern.builder.GetOrderListRequest;

/**
 * Created by User on 2016/4/19.
 */
public class OrderListModel extends FBaseModel
{
    public String mP;

    public OrderListModel()
    {

    }

    @Override protected void sendRequest()
    {
        GetOrderListRequest getOrderListRequest =
                new GetOrderListRequest.ParamsBuilder().setP(mP).build();
        FHttpManager.getInstance().asyncExecute(getOrderListRequest, new FHttpCallback()
        {
            @Override public void onSuccess(String response)
            {
                super.onSuccess(response);
            }
        });
    }
}
