package com.lhj.android_design.banner;

import android.support.v4.view.ViewPager;
import android.widget.TextView;

import com.lhj.android_design.BaseActivity;
import com.lhj.android_design.R;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.listener.OnBannerListener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;



/**
 * Create by xmd on 2018/6/21
 * Describe:
 */
public class BannerTestActivity extends BaseActivity implements OnBannerListener,ViewPager.OnPageChangeListener {

    @BindView(R.id.textView)
    TextView textView;
    @BindView(R.id.banner)
    Banner banner;
    private List images ;
    private List<String> titles;
    @Override
    public int initLayout() {
        return R.layout.activity_banner_test;
    }

    @Override
    public void initView() {

    }

    @Override
    public void initData() {
        images = new ArrayList();
        titles = new ArrayList<>();
        String[] urls = getResources().getStringArray(R.array.url);
        String[] tips = getResources().getStringArray(R.array.title);
        images.addAll(Arrays.asList(urls));
        titles.addAll(Arrays.asList(tips));
        banner.setImages(images)
                .setImageLoader(new GlideImageLoader())
                .setOnBannerListener(this)
                .setBannerTitles(titles)
                .isAutoPlay(true)
                .setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE)
                .setDelayTime(3000)
                .setBannerAnimation(Transformer.DepthPage)
                .start();

    }

    @Override
    public void OnBannerClick(int position) {
        textView.setText(String.valueOf(position));
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
