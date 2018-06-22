package com.lhj.android_design.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.lhj.android_design.R;
import com.lhj.entity.RefreshBean;

import java.util.List;

/**
 * Create by xmd on 2018/6/21
 * Describe:
 */
public class RefreshAdapter extends BaseQuickAdapter<RefreshBean,BaseViewHolder> {

    public RefreshAdapter(int layoutResId, @Nullable List<RefreshBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, RefreshBean item) {
        helper.setText(R.id.textView,item.getName());
    }
}
