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
import com.example.xiaobao.xiaobaokotlin.home4.*
import com.example.xiaobao.xiaobaokotlin.home4.home4_day1_activity
import com.example.xiaobao.xiaobaokotlin.home4.home4_day2_activity
import com.example.xiaobao.xiaobaokotlin.home4.home4_day3_activity

import java.util.ArrayList


class home4_MainActivity : AppCompatActivity(), AdapterView.OnItemClickListener {
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
        arr_data!!.add("4.1.Handler post(Runnable)")
        arr_data!!.add("4.2.Handler postDelayed(Runnable, long);")
        arr_data!!.add("4.3.sendMessage")
        arr_data!!.add("4.4.sendMessageDelayed")
        arr_data!!.add("4.5.Handler与子线程")
        arr_data!!.add("4.6 第6章 主线程与子线程之间的信息交互")
        arr_data!!.add("4.7 第7章 解析Android中更新UI的几种方式")
        arr_data!!.add("4.8 第8章 非UI线程真的不能更新UI吗")
        arr_data!!.add("4.9 第9章 终章：使用Handler时候遇到的问题")




        arr_adapter = ArrayAdapter(this,
                R.layout.support_simple_spinner_dropdown_item,
                arr_data!!)
        listView!!.adapter = arr_adapter
        listView!!.onItemClickListener = this
    }


    override fun onItemClick(adapterView: AdapterView<*>, view: View, i: Int, l: Long) {
        when (i) {
            0 -> {
                val intent = Intent(this@home4_MainActivity, home4_day1_activity::class.java)
                this@home4_MainActivity.startActivity(intent)
            }
            1 -> {
                val intent = Intent(this@home4_MainActivity, home4_day2_activity::class.java)
                this@home4_MainActivity.startActivity(intent)
            }
            2 -> {
                val intent = Intent(this@home4_MainActivity, home4_day3_activity::class.java)
                this@home4_MainActivity.startActivity(intent)
            }
            3 -> {
                val intent = Intent(this@home4_MainActivity, home4_day4_activity::class.java)
                this@home4_MainActivity.startActivity(intent)
            }
            4 -> {
                val intent = Intent(this@home4_MainActivity, home4_day5_activity::class.java)
                this@home4_MainActivity.startActivity(intent)
            }
            5 -> {
                val intent = Intent(this@home4_MainActivity, home4_day6_activity::class.java)
                this@home4_MainActivity.startActivity(intent)
            }
            6 -> {
                val intent = Intent(this@home4_MainActivity, home4_day7_activity::class.java)
                this@home4_MainActivity.startActivity(intent)
            }
            7 -> {
                val intent = Intent(this@home4_MainActivity, home4_day8_activity::class.java)
                this@home4_MainActivity.startActivity(intent)
            }
            else -> {
            }
        }

    }


}
