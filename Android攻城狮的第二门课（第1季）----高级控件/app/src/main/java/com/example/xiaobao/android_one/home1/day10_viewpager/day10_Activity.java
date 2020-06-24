package com.example.xiaobao.android_one.home1.day10_viewpager;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.PagerTabStrip;
import android.support.v4.view.PagerTitleStrip;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Toast;

import com.example.xiaobao.android_one.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiaobao on 2020/6/7.
 */

public class day10_Activity extends FragmentActivity implements ViewPager.OnPageChangeListener {
    private List<View> viewList;
    private ViewPager pager;
    private PagerTabStrip tab;
    private PagerTitleStrip titleStrip;

    private List<String> titleList;
    private List<Fragment> fragList;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.day10_mainview);
        viewList = new ArrayList<>();

        /*
        * 通过view对象去作为ViewPager的数据源
        * */
        View view1 = View.inflate(this, R.layout.day10_view1, null);
        View view2 = View.inflate(this, R.layout.day10_view2, null);
        View view3 = View.inflate(this, R.layout.day10_view3, null);
        View view4 = View.inflate(this, R.layout.day10_view4, null);
        viewList.add(view1);
        viewList.add(view2);
        viewList.add(view3);
        viewList.add(view4);




/*
* 通过Fragment作为ViewPager的数据源
*
* */


        fragList = new ArrayList<Fragment>();
        fragList.add(new day10_Fragment1());
        fragList.add(new day10_Fragment2());
        fragList.add(new day10_Fragment3());
        fragList.add(new day10_Fragment4());


//       为ViewPager页卡设置标题
        titleList = new ArrayList<String>();
        titleList.add("第1页标题");
        titleList.add("第2页标题");
        titleList.add("第3页标题");
        titleList.add("第4页标题");


        if (true) {
//            tab = findViewById(R.id.day10_mainview_tab);
////        背景色
////        tab.setBackgroundColor(Color.YELLOW);
//            tab.setBackgroundColor(0xffffff00);
////        标题颜色
////        tab.setTextColor(Color.RED);
////        颜色前两位表示透明度
//            tab.setTextColor(0xffff0000);
//
////       长下划线
//            tab.setDrawFullUnderline(false);
//
////       短下划线颜色
//            tab.setTabIndicatorColor(0x00000000);
        }


        titleStrip = findViewById(R.id.day10_mainview_title);
//        背景色
//        tab.setBackgroundColor(Color.YELLOW);
        titleStrip.setBackgroundColor(0xffffff00);

//        标题颜色
//        tab.setTextColor(Color.RED);
//        颜色前两位表示透明度
        titleStrip.setTextColor(0xffff0000);


        //        初始化 ViewPager
        ViewPager pager = (ViewPager) findViewById(R.id.day10_mainview_pager);
        pager.setOnPageChangeListener(this);

//        两种方式
        if (true) {
////            方式1  加载所有 fragment 不会销毁
////        创建PagerAdapter的适配器
//            MyFragmentPagerAdapter pagerAdapter = new MyFragmentPagerAdapter(getSupportFragmentManager(), fragList, titleList);
//           pager.setAdapter(pagerAdapter);


            //            方式2 fragment 会销毁
            MyFragmentPagerAdapter2 pagerAdapter2 = new MyFragmentPagerAdapter2(getSupportFragmentManager(), fragList, titleList);
            pager.setAdapter(pagerAdapter2);


        } else {
            //            方式3
            //        创建PagerAdapter的适配器
            MyPagerAdapter adapter = new MyPagerAdapter(viewList, titleList);
            pager.setAdapter(adapter);
        }
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        Toast.makeText(this, "现在是第"+(position + 1)+"页", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
