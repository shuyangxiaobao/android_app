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
import com.example.xiaobao.xiaobaokotlin.home5.day1.home5_day1_activity
import com.example.xiaobao.xiaobaokotlin.home5.day2.home5_day2_activity
import com.example.xiaobao.xiaobaokotlin.home5.day3.home5_day3_activity
import com.example.xiaobao.xiaobaokotlin.home5.day4.home5_day4_activity
import com.example.xiaobao.xiaobaokotlin.home5.day5.*
import com.example.xiaobao.xiaobaokotlin.home5.day6.*

import java.util.ArrayList


class home5_MainActivity : AppCompatActivity(), AdapterView.OnItemClickListener {
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
        arr_data!!.add("5.1. HttpUrlConnection介绍")
        arr_data!!.add("5.2. post、get传递参数（上）")
        arr_data!!.add("5.3. 加载json数据，显示列表")
        arr_data!!.add("5.4. xml解析")
        arr_data!!.add("5.5. 3-1 android多线程下载网络图片")
        arr_data!!.add("5.6. 3-3 http方式实现图片上传")



        arr_adapter = ArrayAdapter(this,
                R.layout.support_simple_spinner_dropdown_item,
                arr_data!!)
        listView!!.adapter = arr_adapter
        listView!!.onItemClickListener = this
    }


    override fun onItemClick(adapterView: AdapterView<*>, view: View, i: Int, l: Long) {
        when (i) {
            0 -> {
                val intent = Intent(this@home5_MainActivity, home5_day1_activity::class.java)
                this@home5_MainActivity.startActivity(intent)
            }
            1 -> {
                val intent = Intent(this@home5_MainActivity, home5_day2_activity::class.java)
                this@home5_MainActivity.startActivity(intent)
            }
            2 -> {
                val intent = Intent(this@home5_MainActivity, home5_day3_activity::class.java)
                this@home5_MainActivity.startActivity(intent)
            }
            3 -> {
                val intent = Intent(this@home5_MainActivity, home5_day4_activity::class.java)
                this@home5_MainActivity.startActivity(intent)
            }
            4 -> {
                val intent = Intent(this@home5_MainActivity, home5_day5_activity::class.java)
                this@home5_MainActivity.startActivity(intent)
            }
            5 -> {
                val intent = Intent(this@home5_MainActivity, home5_day6_activity::class.java)
                this@home5_MainActivity.startActivity(intent)
            }
            else -> {
            }
        }

    }


}
