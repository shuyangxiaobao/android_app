package com.example.xiaobao.xiaobaokotlin

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import com.example.xiaobao.xiaobaokotlin.home_huizong.home1_MainActivity
import com.example.xiaobao.xiaobaokotlin.home_huizong.home2_MainActivity
import com.example.xiaobao.xiaobaokotlin.home_huizong.home3_MainActivity
import com.example.xiaobao.xiaobaokotlin.home_huizong.home4_MainActivity
import com.example.xiaobao.xiaobaokotlin.home_huizong.home5_MainActivity
import com.example.xiaobao.xiaobaokotlin.home_huizong.home6_MainActivity
import com.example.xiaobao.xiaobaokotlin.home_huizong.home7_MainActivity
import com.example.xiaobao.xiaobaokotlin.home_huizong.home8_MainActivity
import com.example.xiaobao.xiaobaokotlin.home_huizong.home9_MainActivity
import com.example.xiaobao.xiaobaokotlin.home_huizong.home10_MainActivity
import com.example.xiaobao.xiaobaokotlin.home_huizong.home11_MainActivity
import com.example.xiaobao.xiaobaokotlin.home_huizong.home12_MainActivity
import com.example.xiaobao.xiaobaokotlin.home_huizong.home13_MainActivity
import com.example.xiaobao.xiaobaokotlin.home_huizong.home14_MainActivity
import com.example.xiaobao.xiaobaokotlin.home_huizong.home15_MainActivity
import com.example.xiaobao.xiaobaokotlin.home_huizong.home16_MainActivity
import com.example.xiaobao.xiaobaokotlin.home_huizong.home17_MainActivity
import com.example.xiaobao.xiaobaokotlin.home_huizong.home18_MainActivity
import com.example.xiaobao.xiaobaokotlin.home_huizong.home19_MainActivity
import com.example.xiaobao.xiaobaokotlin.home_huizong.home20_MainActivity


import kotlinx.android.synthetic.main.root.view.*
import java.util.ArrayList

class MainActivity : AppCompatActivity(), AdapterView.OnItemClickListener {
    private val btn: Button? = null
    private var listView: ListView? = null
    private var arr_adapter: ArrayAdapter<String>? = null
    private var arr_data: MutableList<String>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.root)
        demo1()
    }

    fun demo1() {
        listView = findViewById<View>(R.id.root_listview) as ListView
        arr_data = ArrayList()
        arr_data!!.add("kotlin 跳转到 java")
        arr_data!!.add("home1：Android（第1季）----高级控件")
        arr_data!!.add("home2：Android（第2季）---消息提示和菜单")
        arr_data!!.add("home3：Android (第3季）----四大组件与存储")
        arr_data!!.add("home4：Android面试常客Handler详解")
        arr_data!!.add("home5：Android中的Http通信")
        arr_data!!.add("home6：ListView的常见使用模式")
        arr_data!!.add("home7：Android动画基础")
        arr_data!!.add("home8：Activity")
        arr_data!!.add("home9：androidannotations框架")
        arr_data!!.add("home10：Volley框架")
        arr_data!!.add("home11：各种类型Drawable讲解")
        arr_data!!.add("home12：Canvas 绘图 和矩阵变换")
        arr_data!!.add("home13：kotlin 语法")
        arr_data!!.add("home14：")
        arr_data!!.add("home15：")
        arr_data!!.add("home16：")
        arr_data!!.add("home17：")
        arr_data!!.add("home18：")
        arr_data!!.add("home19：")
        arr_data!!.add("home20：")




        arr_adapter = ArrayAdapter(this,
                R.layout.support_simple_spinner_dropdown_item,
                arr_data!!)
        listView!!.adapter = arr_adapter
        listView!!.onItemClickListener = this
    }


    override fun onItemClick(adapterView: AdapterView<*>, view: View, i: Int, l: Long) {
        when (i) {
            0 -> {
                val intent = Intent(this@MainActivity, TestActivity::class.java)
                this@MainActivity.startActivity(intent)
            }
            1 -> {
                val intent = Intent(this@MainActivity, home1_MainActivity::class.java)
                this@MainActivity.startActivity(intent)
            }
            2 -> {
                val intent = Intent(this@MainActivity, home2_MainActivity::class.java)
                this@MainActivity.startActivity(intent)
            }
            3 -> {
                val intent = Intent(this@MainActivity, home3_MainActivity::class.java)
                this@MainActivity.startActivity(intent)
            }
            4 -> {
                val intent = Intent(this@MainActivity, home4_MainActivity::class.java)
                this@MainActivity.startActivity(intent)
            }
            5 -> {
                val intent = Intent(this@MainActivity, home5_MainActivity::class.java)
                this@MainActivity.startActivity(intent)
            }
            6 -> {
                val intent = Intent(this@MainActivity, home6_MainActivity::class.java)
                this@MainActivity.startActivity(intent)
            }
            7 -> {
                val intent = Intent(this@MainActivity, home7_MainActivity::class.java)
                this@MainActivity.startActivity(intent)
            }
            8 -> {
                val intent = Intent(this@MainActivity, home8_MainActivity::class.java)
                this@MainActivity.startActivity(intent)
            }

            9 -> {
                val intent = Intent(this@MainActivity, home9_MainActivity::class.java)
                this@MainActivity.startActivity(intent)
            }

            10 -> {
                val intent = Intent(this@MainActivity, home10_MainActivity::class.java)
                this@MainActivity.startActivity(intent)
            }
            11 -> {
                val intent = Intent(this@MainActivity, home11_MainActivity::class.java)
                this@MainActivity.startActivity(intent)
            }
            12 -> {
                val intent = Intent(this@MainActivity, home12_MainActivity::class.java)
                this@MainActivity.startActivity(intent)
            }
            13 -> {
                val intent = Intent(this@MainActivity, home13_MainActivity::class.java)
                this@MainActivity.startActivity(intent)
            }
            14 -> {
                val intent = Intent(this@MainActivity, home14_MainActivity::class.java)
                this@MainActivity.startActivity(intent)
            }
            15 -> {
                val intent = Intent(this@MainActivity, home15_MainActivity::class.java)
                this@MainActivity.startActivity(intent)
            }
            16 -> {
                val intent = Intent(this@MainActivity, home16_MainActivity::class.java)
                this@MainActivity.startActivity(intent)
            }
            17 -> {
                val intent = Intent(this@MainActivity, home17_MainActivity::class.java)
                this@MainActivity.startActivity(intent)
            }
            18 -> {
                val intent = Intent(this@MainActivity, home18_MainActivity::class.java)
                this@MainActivity.startActivity(intent)
            }
            19 -> {
                val intent = Intent(this@MainActivity, home19_MainActivity::class.java)
                this@MainActivity.startActivity(intent)
            }
            20 -> {
                val intent = Intent(this@MainActivity, home20_MainActivity::class.java)
                this@MainActivity.startActivity(intent)
            }
        }
        Toast.makeText(this, (i + 1).toString() + "", Toast.LENGTH_SHORT).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("home8_MainActivity", "onDestroy:  MainActivity")

    }
}
