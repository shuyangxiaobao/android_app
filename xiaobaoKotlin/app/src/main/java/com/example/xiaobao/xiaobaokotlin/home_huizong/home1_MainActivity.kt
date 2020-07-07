package com.example.xiaobao.xiaobaokotlin.home_huizong

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.Toast

import java.util.ArrayList

import android.content.Intent

import com.example.xiaobao.xiaobaokotlin.R
import com.example.xiaobao.xiaobaokotlin.home1.*
import com.example.xiaobao.xiaobaokotlin.home1.day7.*
import com.example.xiaobao.xiaobaokotlin.home1.day08_fragment.*
import com.example.xiaobao.xiaobaokotlin.home1.day10_viewpager.*
import com.example.xiaobao.xiaobaokotlin.home1.day11_viewFlipper.*
import com.example.xiaobao.xiaobaokotlin.home1.day12_scrollview.*
import com.example.xiaobao.xiaobaokotlin.home1.day13_Gallery.*
import com.example.xiaobao.xiaobaokotlin.home1.day14_SeekBar.*
import com.example.xiaobao.xiaobaokotlin.home1.day15.*


class home1_MainActivity : AppCompatActivity(), AdapterView.OnItemClickListener {
    private val btn: Button? = null
    private var listView: ListView? = null
    private var arr_adapter: ArrayAdapter<String>? = null
    private var arr_data: MutableList<String>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home1_activity_main)
        demo1()
    }

    fun demo1() {
        listView = findViewById<View>(R.id.listview) as ListView
        arr_data = ArrayList()
        arr_data!!.add("1.1 第1章 解读AndroidManifest配置文件")
        arr_data!!.add("1.2 第2章 使用ListView显示信息列表")
        arr_data!!.add("1.3 第3章 使用DatePicker以及TimePicker显示当前日期和时间")
        arr_data!!.add("1.4 第4章 使用GridView以表格形式显示多张图片")
        arr_data!!.add("1.5 第5章 使用Spinner实现下拉列表")
        arr_data!!.add("1.6 第6章 使用ProgressBar实现进度条")
        arr_data!!.add("1.7 第7章 使用WebView显示网页")
        arr_data!!.add("1.8 第8章 Fragment基础概述")
        arr_data!!.add("1.9 第9章 Fragment与Activity通信")
        arr_data!!.add("1.10 第10章 使用ViewPager实现导航")
        arr_data!!.add("1.11 第11章 使用ViewFlipper实现屏幕切换动画效果")
        arr_data!!.add("1.12 第12章 使用ScrollView实现滚动效果")
        arr_data!!.add("1.13 第13章 使用Gallery和ImageSwitcher制作图片浏览器")
        arr_data!!.add("1.14 第14章 使用SeekBar制作可拖动的进度条")
        arr_data!!.add("1.15 第15章 Android布局优化（大结局）")


        arr_adapter = ArrayAdapter(this,
                R.layout.support_simple_spinner_dropdown_item,
                arr_data!!)
        listView!!.adapter = arr_adapter
        listView!!.onItemClickListener = this
    }




    override fun onItemClick(adapterView: AdapterView<*>, view: View, i: Int, l: Long) {
        when (i) {
            0 -> {
                val intent = Intent()
                intent.action = "day01"
                intent.addCategory("android.intent.category.DEFAULT")
                startActivity(intent)
            }
            1 -> {
                val intent = Intent(this@home1_MainActivity, day02_activity::class.java)
                this@home1_MainActivity.startActivity(intent)
            }
            2 -> {
                val intent = Intent(this@home1_MainActivity, day03_Activity::class.java)
                this@home1_MainActivity.startActivity(intent)
            }
            3 -> {
                val intent = Intent(this@home1_MainActivity, day04_Activity::class.java)
                this@home1_MainActivity.startActivity(intent)
            }
            4 -> {
                val intent = Intent(this@home1_MainActivity, day05_Activity::class.java)
                this@home1_MainActivity.startActivity(intent)
            }
            5 -> {
                val intent = Intent(this@home1_MainActivity, day06_Activity::class.java)
                this@home1_MainActivity.startActivity(intent)
            }
            6 -> {
                val intent = Intent(this@home1_MainActivity, day07_webview_Activity::class.java)
                this@home1_MainActivity.startActivity(intent)
            }
            7 -> {
                val intent = Intent(this@home1_MainActivity, day08_fragment_Activity::class.java)
                this@home1_MainActivity.startActivity(intent)
            }
            8 -> {
                val intent = Intent(this@home1_MainActivity, day08_fragment_Activity::class.java)
                this@home1_MainActivity.startActivity(intent)
            }
            9 -> {
                val intent = Intent(this@home1_MainActivity, day10_Activity::class.java)
                this@home1_MainActivity.startActivity(intent)
            }
            10 -> {
                val intent = Intent(this@home1_MainActivity, day11_Activity::class.java)
                this@home1_MainActivity.startActivity(intent)
            }
            11 -> {
                val intent = Intent(this@home1_MainActivity, day12_Activity::class.java)
                this@home1_MainActivity.startActivity(intent)
            }
            12 -> {
                Log.i("main", "onItemClick: $i")
                Log.i("xlp", "onItemClick: $i")
                val intent = Intent(this@home1_MainActivity, day13_Activity::class.java)
                this@home1_MainActivity.startActivity(intent)
                for (t in 0..99) {
                    println(t)
                }
            }
            13 -> {
                val intent = Intent(this@home1_MainActivity, day14_Activity::class.java)
                this@home1_MainActivity.startActivity(intent)
            }
            14 -> {
                val intent = Intent(this@home1_MainActivity, day15_Activity::class.java)
                this@home1_MainActivity.startActivity(intent)
            }
        }
        Toast.makeText(this, (i + 1).toString() + "", Toast.LENGTH_SHORT).show()
    }

}
