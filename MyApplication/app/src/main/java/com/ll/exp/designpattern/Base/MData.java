package com.ll.exp.designpattern.Base;

import java.io.Serializable;

/**
 * Created by User on 2016/4/19.
 */
public class MData<T> implements Serializable
{
    public String id;
    public String type;
    public T dataList;
}
