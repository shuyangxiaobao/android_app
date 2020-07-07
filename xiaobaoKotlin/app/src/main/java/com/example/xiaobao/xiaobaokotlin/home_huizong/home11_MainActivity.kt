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
import com.example.xiaobao.xiaobaokotlin.home11.day1.home11_day1_activity
import com.example.xiaobao.xiaobaokotlin.home11.day2.home11_day2_activity
import com.example.xiaobao.xiaobaokotlin.home11.day3.home11_day3_activity
import com.example.xiaobao.xiaobaokotlin.home11.day4.home11_day4_activity
import com.example.xiaobao.xiaobaokotlin.home11.day5.home11_day5_activity
import com.example.xiaobao.xiaobaokotlin.home11.day6.home11_day6_activity
import com.example.xiaobao.xiaobaokotlin.home11.day7.home11_day7_activity
import com.example.xiaobao.xiaobaokotlin.home11.day8.home11_day8_activity

import java.util.ArrayList


class home11_MainActivity : AppCompatActivity(), AdapterView.OnItemClickListener {
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
        arr_data!!.add("11.1 BitmapDrawable的用法")
        arr_data!!.add("11.2 LayerDrawable的用法")
        arr_data!!.add("11.3 StateListDrawable的用法")
        arr_data!!.add("11.4 LevelListDrawable的用法")
        arr_data!!.add("11.5 TransitionDrawable的用法")
        arr_data!!.add("11.6 InsertDrawable的用法")
        arr_data!!.add("11.7 ClipDrawable的用法")
        arr_data!!.add("11.8 编写自定义Drawable")



        arr_adapter = ArrayAdapter(this,
                R.layout.support_simple_spinner_dropdown_item,
                arr_data!!)
        listView!!.adapter = arr_adapter
        listView!!.onItemClickListener = this
    }


    override fun onItemClick(adapterView: AdapterView<*>, view: View, i: Int, l: Long) {
        when (i + 1) {
            1 -> {
                val intent = Intent(this@home11_MainActivity, home11_day1_activity::class.java)
                this@home11_MainActivity.startActivity(intent)
            }
            2 -> {
                val intent = Intent(this@home11_MainActivity, home11_day2_activity::class.java)
                this@home11_MainActivity.startActivity(intent)
            }
            3 -> {
                val intent = Intent(this@home11_MainActivity, home11_day3_activity::class.java)
                this@home11_MainActivity.startActivity(intent)
            }
            4 -> {
                val intent = Intent(this@home11_MainActivity, home11_day4_activity::class.java)
                this@home11_MainActivity.startActivity(intent)
            }
            5 -> {
                val intent = Intent(this@home11_MainActivity, home11_day5_activity::class.java)
                this@home11_MainActivity.startActivity(intent)
            }
            6 -> {
                val intent = Intent(this@home11_MainActivity, home11_day6_activity::class.java)
                this@home11_MainActivity.startActivity(intent)
            }
            7 -> {
                val intent = Intent(this@home11_MainActivity, home11_day7_activity::class.java)
                this@home11_MainActivity.startActivity(intent)
            }
            8 -> {
                val intent = Intent(this@home11_MainActivity, home11_day8_activity::class.java)
                this@home11_MainActivity.startActivity(intent)
            }


            else -> {
            }
        }

    }


}
