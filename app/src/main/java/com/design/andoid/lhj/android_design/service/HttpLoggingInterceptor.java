package com.design.andoid.lhj.android_design.service;import com.orhanobut.logger.Logger;import java.io.IOException;import okhttp3.FormBody;import okhttp3.Interceptor;import okhttp3.Request;import okhttp3.RequestBody;import okhttp3.Response;/** * Created by lhj on 18/5/10 */public class HttpLoggingInterceptor implements Interceptor {    @Override    public Response intercept(Chain chain) throws IOException {        Request request = chain.request();        String hear = request.header("User-Agent");        request = request.newBuilder().header("User-Agent",hear + "-android"+ 1.0).build();//        if(TechApplication.isTest){////        }        Logger.d(requestToString(request));        Response response = chain.proceed(request);        return response;    }    private String requestToString(Request request) {        String result = request.method() + ":" + request.url().toString();        RequestBody requestBody = request.body();        if (requestBody != null) {            if (requestBody instanceof FormBody) {                FormBody body = (FormBody) request.body();                result += "----params:";                for (int i = 0; i < body.size(); i++) {                    result += body.name(i) + "=" + body.value(i) + "&";                }                result = result.substring(0, result.length() - 1);            } else {                result += "----un form data!";            }        }        return result;    }}