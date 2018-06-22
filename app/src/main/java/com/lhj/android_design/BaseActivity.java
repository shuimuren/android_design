package com.lhj.android_design;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;

import com.lhj.android_design.utils.ReflectionUtil;
import com.orhanobut.logger.Logger;

import butterknife.ButterKnife;


/**
 * Create by xmd on 2018/6/21
 * Describe: 基类activity
 */
public abstract class BaseActivity extends AppCompatActivity {
    /**
     * 是否显示标题栏
     */
    private boolean isShowTitle = true;
    /**
     * 是否显示状态栏
     */
    private boolean isShowState = true;

    /**
     * 获取Tag的activity名称
     */
    protected final String TAG = this.getClass().getSimpleName();

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(isShowTitle){
            requestWindowFeature(Window.FEATURE_NO_TITLE);
        }
        if(!isShowState){
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }
        setContentView(initLayout());
        ButterKnife.bind(this);
        initView();
        initData();
        Logger.i("activity: "+getClass().getSimpleName() + "onCreate()");
    }

    /**
     * 设置布局
     * @return
     */
    public abstract int initLayout();

    /**
     * 初始化布局
     */
    public abstract void initView();

    /**
     * 设置数据
     */
    public abstract void initData();

    @Override
    public void onBackPressed() {
        invokeFragmentManagerNoteStateNotSaved();
        super.onBackPressed();
    }
    private void invokeFragmentManagerNoteStateNotSaved() {
        FragmentManager fm = getSupportFragmentManager();
        ReflectionUtil.invokeMethod(fm, "noteStateNotSaved", null);
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }
}
