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
import com.example.xiaobao.xiaobaokotlin.home13.day1.home13_day1_activity
import com.example.xiaobao.xiaobaokotlin.home13.day2.home13_day2_activity
import com.example.xiaobao.xiaobaokotlin.home13.day3.home13_day3_activity
import com.example.xiaobao.xiaobaokotlin.home13.day4.home13_day4_activity
import com.example.xiaobao.xiaobaokotlin.home13.day5.home13_day5_activity
import com.example.xiaobao.xiaobaokotlin.home13.day6.home13_day6_activity
import com.example.xiaobao.xiaobaokotlin.home13.day7.home13_day7_activity
import com.example.xiaobao.xiaobaokotlin.home13.day8.home13_day8_activity
import com.example.xiaobao.xiaobaokotlin.home13.day9.home13_day9_activity
import com.example.xiaobao.xiaobaokotlin.home13.day10.home13_day10_activity
import com.example.xiaobao.xiaobaokotlin.home13.day11.home13_day11_activity
import com.example.xiaobao.xiaobaokotlin.home13.day12.home13_day12_activity
import com.example.xiaobao.xiaobaokotlin.home13.day13.home13_day13_activity
import com.example.xiaobao.xiaobaokotlin.home13.day14.home13_day14_activity
import com.example.xiaobao.xiaobaokotlin.home13.day15.home13_day15_activity
import com.example.xiaobao.xiaobaokotlin.home13.day16.home13_day16_activity
import com.example.xiaobao.xiaobaokotlin.home13.day17.home13_day17_activity
import com.example.xiaobao.xiaobaokotlin.home13.day18.home13_day18_activity
import com.example.xiaobao.xiaobaokotlin.home13.day19.home13_day19_activity
import com.example.xiaobao.xiaobaokotlin.home13.day20.home13_day20_activity

import java.util.ArrayList


class home13_MainActivity : AppCompatActivity(), AdapterView.OnItemClickListener {
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
        arr_data!!.add("13.1 数组")
        arr_data!!.add("13.2 NULL检查机制")
        arr_data!!.add("13.3 区间")
        arr_data!!.add("13.4 字符")
        arr_data!!.add("13.5 Kotlin 条件控制")
        arr_data!!.add("13.6 Kotlin 循环控制")
        arr_data!!.add("13.7 类和对象 类的属性,set get方法")
        arr_data!!.add("13.8 Kotlin 继承")
        arr_data!!.add("13.9 Kotlin 接口")
        arr_data!!.add("13.10 Kotlin 扩展")
        arr_data!!.add("13.11 Kotlin 单例")
        arr_data!!.add("13.12 自定义属性代理 set get方法")
        arr_data!!.add("13.13 Kotlin 数据类与密封类")
        arr_data!!.add("13.14")
        arr_data!!.add("13.15")
        arr_data!!.add("13.16")
        arr_data!!.add("13.17")
        arr_data!!.add("13.18")
        arr_data!!.add("13.19")
        arr_data!!.add("13.20")

        arr_adapter = ArrayAdapter(this,
                R.layout.support_simple_spinner_dropdown_item,
                arr_data!!)
        listView!!.adapter = arr_adapter
        listView!!.onItemClickListener = this
    }


    override fun onItemClick(adapterView: AdapterView<*>, view: View, i: Int, l: Long) {
        when (i + 1) {
            1 -> {
                val intent = Intent(this@home13_MainActivity, home13_day1_activity::class.java)
                this@home13_MainActivity.startActivity(intent)
            }
            2 -> {
                val intent = Intent(this@home13_MainActivity, home13_day2_activity::class.java)
                this@home13_MainActivity.startActivity(intent)
            }

            3->{
                val intent = Intent(this@home13_MainActivity, home13_day3_activity::class.java)
                startActivity(intent)
            }
            4->{
                val intent = Intent(this@home13_MainActivity, home13_day4_activity::class.java)
                startActivity(intent)
            }
            5->{
                val intent = Intent(this@home13_MainActivity, home13_day5_activity::class.java)
                startActivity(intent)
            }
            6->{
                val intent = Intent(this@home13_MainActivity, home13_day6_activity::class.java)
                startActivity(intent)
            }
            7->{
                val intent = Intent(this@home13_MainActivity, home13_day7_activity::class.java)
                startActivity(intent)
            }
            8->{
                val intent = Intent(this@home13_MainActivity, home13_day8_activity::class.java)
                startActivity(intent)
            }
            9->{
                val intent = Intent(this@home13_MainActivity, home13_day9_activity::class.java)
                startActivity(intent)
            }
            10->{
                val intent = Intent(this@home13_MainActivity, home13_day10_activity::class.java)
                startActivity(intent)
            }
            11->{
                val intent = Intent(this@home13_MainActivity, home13_day11_activity::class.java)
                startActivity(intent)
            }
            12->{
                val intent = Intent(this@home13_MainActivity, home13_day12_activity::class.java)
                startActivity(intent)
            }
            13->{
                val intent = Intent(this@home13_MainActivity, home13_day13_activity::class.java)
                startActivity(intent)
            }
            14->{
                val intent = Intent(this@home13_MainActivity, home13_day14_activity::class.java)
                startActivity(intent)
            }
            15->{
                val intent = Intent(this@home13_MainActivity, home13_day15_activity::class.java)
                startActivity(intent)
            }
            16->{
                val intent = Intent(this@home13_MainActivity, home13_day16_activity::class.java)
                startActivity(intent)
            }
            17->{
                val intent = Intent(this@home13_MainActivity, home13_day17_activity::class.java)
                startActivity(intent)
            }
            18->{
                val intent = Intent(this@home13_MainActivity, home13_day18_activity::class.java)
                startActivity(intent)
            }
            19->{
                val intent = Intent(this@home13_MainActivity, home13_day19_activity::class.java)
                startActivity(intent)
            }
            20->{
                val intent = Intent(this@home13_MainActivity, home13_day20_activity::class.java)
                startActivity(intent)
            }




            else -> {
            }
        }

    }


}
