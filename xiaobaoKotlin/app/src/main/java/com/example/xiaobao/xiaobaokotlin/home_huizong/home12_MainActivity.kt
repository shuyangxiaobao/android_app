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
import com.example.xiaobao.xiaobaokotlin.home12.day1.home12_day1_activity
import com.example.xiaobao.xiaobaokotlin.home12.day2.home12_day2_activity
import com.example.xiaobao.xiaobaokotlin.home12.day3.home12_day3_activity
import com.example.xiaobao.xiaobaokotlin.home12.day4.home12_day4_activity
import com.example.xiaobao.xiaobaokotlin.home12.day5.home12_day5_activity
import com.example.xiaobao.xiaobaokotlin.home12.day6.home12_day6_activity
import com.example.xiaobao.xiaobaokotlin.home12.day7.home12_day7_activity
import com.example.xiaobao.xiaobaokotlin.home12.day8.home12_day8_activity

import java.util.ArrayList


class home12_MainActivity : AppCompatActivity(), AdapterView.OnItemClickListener {
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
        arr_data!!.add("12.1 Canvas 绘图")
        arr_data!!.add("12.2 贝塞尔曲线")
        arr_data!!.add("12.3 自定义手指轨迹画板")
        arr_data!!.add("12.4 自定义手指轨迹画板(贝塞尔曲线)")
        arr_data!!.add("12.5 水波纹效果")
        arr_data!!.add("12.6 rQuadTo 和 quadTo 区别")
        arr_data!!.add("12.7 Matrix(矩阵)变换")
        arr_data!!.add("12.8 ")



        arr_adapter = ArrayAdapter(this,
                R.layout.support_simple_spinner_dropdown_item,
                arr_data!!)
        listView!!.adapter = arr_adapter
        listView!!.onItemClickListener = this
    }


    override fun onItemClick(adapterView: AdapterView<*>, view: View, i: Int, l: Long) {
        when (i + 1) {
            1 -> {
                //                Intent intent = new Intent(home12_MainActivity.this, home11_day1_activity.class);
                //                home12_MainActivity.this.startActivity(intent);
                //                break;

                val intent = Intent(this@home12_MainActivity, home12_day1_activity::class.java)
                this@home12_MainActivity.startActivity(intent)
            }
            2 -> {
                val intent = Intent(this@home12_MainActivity, home12_day2_activity::class.java)
                this@home12_MainActivity.startActivity(intent)
            }
            3 -> {
                val intent = Intent(this@home12_MainActivity, home12_day3_activity::class.java)
                this@home12_MainActivity.startActivity(intent)
            }
            4 -> {
                val intent = Intent(this@home12_MainActivity, home12_day4_activity::class.java)
                this@home12_MainActivity.startActivity(intent)
            }
            5 -> {
                val intent = Intent(this@home12_MainActivity, home12_day5_activity::class.java)
                this@home12_MainActivity.startActivity(intent)
            }
            6 -> {
                val intent = Intent(this@home12_MainActivity, home12_day6_activity::class.java)
                this@home12_MainActivity.startActivity(intent)
            }
            7 -> {
                val intent = Intent(this@home12_MainActivity, home12_day7_activity::class.java)
                this@home12_MainActivity.startActivity(intent)
            }
            8 -> {
                val intent = Intent(this@home12_MainActivity, home12_day8_activity::class.java)
                this@home12_MainActivity.startActivity(intent)
            }


            else -> {
            }
        }

    }


}
