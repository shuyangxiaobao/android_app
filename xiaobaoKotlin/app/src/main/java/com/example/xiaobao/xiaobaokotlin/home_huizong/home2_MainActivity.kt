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
import com.example.xiaobao.xiaobaokotlin.home1.day02_activity
import com.example.xiaobao.xiaobaokotlin.home2.*
import com.example.xiaobao.xiaobaokotlin.home2.home2_day3_activity

import java.util.ArrayList


class home2_MainActivity : AppCompatActivity(), AdapterView.OnItemClickListener {
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
        arr_data!!.add("2.1 第1章 使用Debug方式调试程序")
        arr_data!!.add("2.2 第2章 使用LogCat方式调试程序")
        arr_data!!.add("2.3 第3章 使用Toast动态显示信息")
        arr_data!!.add("2.4 第4章 使用AlertDialog实现提示框")
        arr_data!!.add("2.5 第5章 使用Notification实现状态通知栏的通知")
        arr_data!!.add("2.6 第6章 使用OptionsMenu实现选项菜单")
        arr_data!!.add("2.7 第7章 使用ContextMenu实现上下文菜单")
        arr_data!!.add("2.8 第8章 使用SubMenu创建子菜单")


        arr_adapter = ArrayAdapter(this,
                R.layout.support_simple_spinner_dropdown_item,
                arr_data!!)
        listView!!.adapter = arr_adapter
        listView!!.onItemClickListener = this
    }


    override fun onItemClick(adapterView: AdapterView<*>, view: View, i: Int, l: Long) {
        when (i + 1) {
            1 -> {
                val intent = Intent()
                intent.action = "day01"
                intent.addCategory("android.intent.category.DEFAULT")
                startActivity(intent)
            }
            2 -> {
                val intent = Intent(this@home2_MainActivity, day02_activity::class.java)
                this@home2_MainActivity.startActivity(intent)
            }
            3 -> {
                val intent = Intent(this@home2_MainActivity, home2_day3_activity::class.java)
                this@home2_MainActivity.startActivity(intent)
            }
            4 -> {
                val intent = Intent(this@home2_MainActivity, home2_day4_activity::class.java)
                this@home2_MainActivity.startActivity(intent)
            }
            5 -> {
                val intent = Intent(this@home2_MainActivity, home2_day5_activity::class.java)
                this@home2_MainActivity.startActivity(intent)
            }
            6 -> {
                val intent = Intent(this@home2_MainActivity, home2_day6_activity::class.java)
                this@home2_MainActivity.startActivity(intent)
            }
            7 -> {
                val intent = Intent(this@home2_MainActivity, home2_day7_activity::class.java)
                this@home2_MainActivity.startActivity(intent)
            }
            8 -> {
                val intent = Intent(this@home2_MainActivity, home2_day8_activity::class.java)
                this@home2_MainActivity.startActivity(intent)
            }
        }


        //        Toast.makeText(this, i+1+"", Toast.LENGTH_SHORT).show();
    }


}
