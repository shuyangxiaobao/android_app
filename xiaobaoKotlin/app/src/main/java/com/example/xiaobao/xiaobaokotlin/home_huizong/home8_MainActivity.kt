package com.example.xiaobao.xiaobaokotlin.home_huizong

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView

import com.example.xiaobao.xiaobaokotlin.R
import com.example.xiaobao.xiaobaokotlin.home8.day1.home8_day1_activity_first
import com.example.xiaobao.xiaobaokotlin.home8.day2.home8_day2_activity_first
import com.example.xiaobao.xiaobaokotlin.home8.day3.home8_day3_activity_first
import com.example.xiaobao.xiaobaokotlin.home8.day4.home8_day4_activity_first
import com.example.xiaobao.xiaobaokotlin.home8.day5.home8_day5_activity_first

import java.util.ArrayList


class home8_MainActivity : AppCompatActivity(), AdapterView.OnItemClickListener {
    private val btn: Button? = null
    private var listView: ListView? = null
    private var arr_adapter: ArrayAdapter<String>? = null
    private var arr_data: MutableList<String>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home1_activity_main)
        demo1()
        println("++++++++++++:$taskId")

    }

    fun demo1() {
        listView = findViewById<View>(R.id.listview) as ListView
        arr_data = ArrayList()
        arr_data!!.add("8.1 Activity生命周期 以及 横竖屏切换")
        arr_data!!.add("8.2 启动Activity方式")
        arr_data!!.add("8.3 Activity数据交换")
        arr_data!!.add("8.4 taskid")
        arr_data!!.add("8.5 启动模式")

        arr_adapter = ArrayAdapter(this,
                R.layout.support_simple_spinner_dropdown_item,
                arr_data!!)
        listView!!.adapter = arr_adapter
        listView!!.onItemClickListener = this
    }


    override fun onItemClick(adapterView: AdapterView<*>, view: View, i: Int, l: Long) {
        when (i) {
            0 -> {
                val intent = Intent(this@home8_MainActivity, home8_day1_activity_first::class.java)
                this@home8_MainActivity.startActivity(intent)
            }
            1 -> {
                val intent = Intent(this@home8_MainActivity, home8_day2_activity_first::class.java)
                this@home8_MainActivity.startActivity(intent)
            }

            2 -> {
                val intent = Intent(this@home8_MainActivity, home8_day3_activity_first::class.java)
                this@home8_MainActivity.startActivity(intent)
            }
            3 -> {
                val intent = Intent(this@home8_MainActivity, home8_day4_activity_first::class.java)
                this@home8_MainActivity.startActivity(intent)
            }
            4 -> {
                val intent = Intent(this@home8_MainActivity, home8_day5_activity_first::class.java)
                this@home8_MainActivity.startActivity(intent)
            }


            else -> {
            }
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("home8_MainActivity", "onDestroy:  home8_MainActivity")
    }
}
