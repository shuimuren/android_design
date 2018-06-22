package com.lhj.android_design.refresh;


import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.lhj.android_design.BaseActivity;
import com.lhj.android_design.R;
import com.lhj.android_design.adapter.RefreshAdapter;
import com.lhj.entity.RefreshBean;
import com.orhanobut.logger.Logger;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;


import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;


/**
 * Create by xmd on 2018/6/21
 * Describe: 测试SmartRefreshLayout
 */
public class SmartRefreshTestActivity extends BaseActivity {

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.smartRefresh)
    SmartRefreshLayout smartRefresh;

    private List<RefreshBean> data;

    @Override
    public int initLayout() {
        return R.layout.activity_smart_refresh_test;
    }

    @Override
    public void initView() {


        recyclerView.setLayoutManager(new LinearLayoutManager(this));


    }

    @Override
    public void initData() {
        initRefreshData();
        BaseQuickAdapter refreshAdapter = new RefreshAdapter(R.layout.refresh_item_view, data);
        recyclerView.setAdapter(refreshAdapter);
        smartRefresh.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                refreshLayout.getLayout().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        initRefreshData();
                        refreshAdapter.notifyDataSetChanged();
                        refreshLayout.setNoMoreData(false);
                        refreshLayout.finishRefresh();
                    }
                }, 2000);
            }
        });
        smartRefresh.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                Logger.i("onLoadMore");
                refreshLayout.getLayout().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if (data.size() > 38) {
                            Toast.makeText(getApplication(), "数据全部加载完毕", Toast.LENGTH_SHORT).show();
                            smartRefresh.finishLoadMoreWithNoMoreData();
                        } else {
                            refreshAdapter.setNewData(addListData());
                            refreshLayout.finishLoadMore();
                        }
                    }
                }, 2000);

            }
        });


    }

    private void initRefreshData() {
        if (data == null) {
            data = new ArrayList<>();
        } else {
            data.clear();
        }

        for (int i = 0; i < 20; i++) {
            data.add(new RefreshBean("A....." + i));
        }
    }

    private List<RefreshBean> addListData() {
        for (int i = 0; i < 10; i++) {
            data.add(new RefreshBean("B*********" + i));
        }
        return data;
    }

}
