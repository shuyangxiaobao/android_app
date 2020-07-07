package com.example.xiaobao.xiaobaokotlin.home_huizong

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView

import com.example.xiaobao.xiaobaokotlin.R
import com.example.xiaobao.xiaobaokotlin.home3.*
import com.example.xiaobao.xiaobaokotlin.home3.day2.home3_day2_activity
import com.example.xiaobao.xiaobaokotlin.home3.day3.home3_day3_activity
import com.example.xiaobao.xiaobaokotlin.home3.day4.home3_day4_activity
import com.example.xiaobao.xiaobaokotlin.home3.day5.home3_day5_activity
import com.example.xiaobao.xiaobaokotlin.home3.day6.home3_day6_activity
import com.example.xiaobao.xiaobaokotlin.home3.day7.home3_day7_activity

import java.util.ArrayList


class home3_MainActivity : AppCompatActivity(), AdapterView.OnItemClickListener {
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
        arr_data!!.add("3.0 第0章 四大组件之Activity")
        arr_data!!.add("3.1 第1章 数据存储之SharedPreferences")
        arr_data!!.add("3.2 第2章 数据存储之SQLite")
        arr_data!!.add("3.3 第3章 数据存储之文件存储")
        arr_data!!.add("3.4 第4章 四大组件之ContentProvider")
        arr_data!!.add("3.5 第5章 四大组件之BroadcastReceiver")
        arr_data!!.add("3.6 第6章 四大组件之Service")
        arr_data!!.add("3.7 第7章 Android中常用的系统服务")
        arr_data!!.add("3.8 第8章 使用GestureDetector进行手势识别")
        arr_data!!.add("3.9 第9章 使用GestureOverlayView进行手势识别")



        arr_adapter = ArrayAdapter(this,
                R.layout.support_simple_spinner_dropdown_item,
                arr_data!!)
        listView!!.adapter = arr_adapter
        listView!!.onItemClickListener = this
    }


    override fun onItemClick(adapterView: AdapterView<*>, view: View, i: Int, l: Long) {
        when (i) {
            0 -> {
                val intent = Intent(this@home3_MainActivity, home3_day0_activity::class.java)
                this@home3_MainActivity.startActivity(intent)
            }
            1 -> {
                val intent = Intent(this@home3_MainActivity, home3_day1_activity::class.java)
                this@home3_MainActivity.startActivity(intent)
            }
            2 -> {
                val intent = Intent(this@home3_MainActivity, home3_day2_activity::class.java)
                this@home3_MainActivity.startActivity(intent)
            }
            3 -> {
                val intent = Intent(this@home3_MainActivity, home3_day3_activity::class.java)
                this@home3_MainActivity.startActivity(intent)
            }
            4 -> {
                val intent = Intent(this@home3_MainActivity, home3_day4_activity::class.java)
                this@home3_MainActivity.startActivity(intent)
            }
            5 -> {
                val intent = Intent(this@home3_MainActivity, home3_day5_activity::class.java)
                this@home3_MainActivity.startActivity(intent)
            }
            6 -> {
                val intent = Intent(this@home3_MainActivity, home3_day6_activity::class.java)
                this@home3_MainActivity.startActivity(intent)
            }
            7 -> {
                val intent = Intent(this@home3_MainActivity, home3_day7_activity::class.java)
                this@home3_MainActivity.startActivity(intent)
            }
            8 -> {
                val intent = Intent(this@home3_MainActivity, home3_day8_activity::class.java)
                this@home3_MainActivity.startActivity(intent)
            }
            9 -> {
                val intent = Intent(this@home3_MainActivity, home3_day9_activity::class.java)
                this@home3_MainActivity.startActivity(intent)
            }
        }

    }


}
