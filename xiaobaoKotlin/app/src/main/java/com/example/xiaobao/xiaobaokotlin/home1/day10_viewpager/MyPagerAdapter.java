package com.example.xiaobao.xiaobaokotlin.home1.day10_viewpager;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by xiaobao on 2020/6/8.
 */

public class MyPagerAdapter extends PagerAdapter {

    private List<View>viewList;
    private List<String> titleList;

    public MyPagerAdapter(List<View> viewList, List<String> titleList) {
        this.viewList = viewList;
        this.titleList = titleList;
    }

    //    返回页卡的数量
    @Override
    public int getCount() {
        return viewList.size();
    }

    // View是否来自于对象
    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    /**
     * 实例化一个页卡
     */
    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        container.addView(viewList.get(position));
        return viewList.get(position);
    }


    /**
     * 销毁一个页卡
     */
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        System.out.println("position = " + position);
        container.removeView(viewList.get(position));
    }
/*
* 设置Viewpager 页卡的标题
* */

    @Override
    public CharSequence getPageTitle(int position) {
        return titleList.get(position);
    }
}
