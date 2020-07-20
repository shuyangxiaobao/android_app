package com.example.xiaobao.xiaobaokotlin.home13.day7

import android.app.Activity
import android.os.Bundle
import android.widget.TextView
import com.example.xiaobao.xiaobaokotlin.R

/**
 * Created by xiaobao on 2020/7/9.
 */
class home13_day7_activity : Activity() {

    var textView: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home13_day3_firstview)
        textView = findViewById(R.id.textView)
        demo1()

        fun1(200)
        println("<<<<<<<<<<<<<<<<<")
        println(::test1 is ()->Unit)
        println(">>>>>>>>>>>>>>>>>")


    }

    fun test1(){
        println("test111")
    }

    // 变量接收函数
    var fun1 = fun(x:Int): Long {
        println("x是$x")
        return x.toLong()
    }

    fun sum(a:Int,b:Int) = a + b;

    // lamada 表达式



    fun demo1(): Unit {
        var roob = Runoob("xiaoming", 12)
        println(roob.name)  // xiaoming添加
        println(roob)  // Runoob(name=xiaoming添加, age=12)


        textView?.setText("""
       var roob = Runoob("xiaoming", 12)
        println(roob)
            """)
    }
}