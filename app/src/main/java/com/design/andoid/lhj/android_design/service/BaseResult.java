package com.design.android.lhj.android_design.service;import java.io.Serializable;/** * Created by lhj on 18/5/8 */public class BaseResult<T> implements Serializable {    public int statusCode;    public String msg;    public int pageCount;    public T respData;}