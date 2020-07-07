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
import com.example.xiaobao.xiaobaokotlin.home6.day1.home6_day1_activity
import com.example.xiaobao.xiaobaokotlin.home6.day2.home6_day2_activity
import com.example.xiaobao.xiaobaokotlin.home6.day3.home6_day3_activity
import com.example.xiaobao.xiaobaokotlin.home6.day4.home6_day4_activity
import com.example.xiaobao.xiaobaokotlin.home6.day5.home6_day5_activity

import java.util.ArrayList


class home6_MainActivity : AppCompatActivity(), AdapterView.OnItemClickListener {
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
        arr_data!!.add("6.1 Android必学-异步加载")
        arr_data!!.add("6.2 Android必学-AsyncTask基础")
        arr_data!!.add("Android必学-BaseAdapter的使用与优化")

        arr_adapter = ArrayAdapter(this,
                R.layout.support_simple_spinner_dropdown_item,
                arr_data!!)
        listView!!.adapter = arr_adapter
        listView!!.onItemClickListener = this
    }


    override fun onItemClick(adapterView: AdapterView<*>, view: View, i: Int, l: Long) {
        when (i) {
            0 -> {
                val intent = Intent(this@home6_MainActivity, home6_day1_activity::class.java)
                this@home6_MainActivity.startActivity(intent)
            }
            1 -> {
                val intent = Intent(this@home6_MainActivity, home6_day2_activity::class.java)
                this@home6_MainActivity.startActivity(intent)
            }
            2 -> {
                val intent = Intent(this@home6_MainActivity, home6_day3_activity::class.java)
                this@home6_MainActivity.startActivity(intent)
            }
            3 -> {
                val intent = Intent(this@home6_MainActivity, home6_day4_activity::class.java)
                this@home6_MainActivity.startActivity(intent)
            }
            4 -> {
                val intent = Intent(this@home6_MainActivity, home6_day5_activity::class.java)
                this@home6_MainActivity.startActivity(intent)
            }
            else -> {
            }
        }

    }


}
