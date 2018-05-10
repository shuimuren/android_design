package com.design.andoid.lhj.android_design;import android.app.Application;import com.design.andoid.lhj.android_design.service.OkHttpUtil;import com.design.andoid.lhj.android_design.service.RetrofitServiceFactory;import com.orhanobut.logger.AndroidLogAdapter;import com.orhanobut.logger.Logger;import java.io.File;/** * Created by lhj on 18/5/8 */public class DesignApplication extends Application{    @Override    public void onCreate() {        super.onCreate();        Logger.addLogAdapter(new AndroidLogAdapter());        OkHttpUtil.getInstance().init(getApplicationContext().getFilesDir() + File.separator + "design",                10*1024*1024,20000,20000,20000);        OkHttpUtil.getInstance().setLog(true);        AppManager.getManagerInstance().initialize(getApplicationContext());        RetrofitServiceFactory.recreateService();    }}