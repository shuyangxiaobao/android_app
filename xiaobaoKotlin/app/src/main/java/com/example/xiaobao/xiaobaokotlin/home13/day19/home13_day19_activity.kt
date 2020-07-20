package com.example.xiaobao.xiaobaokotlin.home13.day19

import android.app.Activity
import android.os.Bundle
import android.widget.TextView
import com.example.xiaobao.xiaobaokotlin.R

/**
 * Created by xiaobao on 2020/7/9.
 */
class home13_day19_activity:Activity() {

    var textView:TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home13_day19_firstview)
        textView = findViewById(R.id.textView)
        demo1()

    }


    fun demo1(): Unit {
        val a =  0..4
        for (item in a){
            println(":$item ") //      0,1,2,3,4
        }

        // 使用 step 指定步长
        val b = 1..10 step 3
        for (item in b){
            println(":$item ") //      1,4,7,10
        }

        val c = 10 downTo 1 step 2
        for (item in c){
            println(":$item ") //      10,8,6,4,2
        }

        // 使用 until 函数排除结束元素
        val d = 1 until 9
        for (i in d) {   //
            print("$i,") // 1,2,3,4,5,6,7,8
        }
        println("😄😄")


        textView?.setText("""
        val a =  0..4
        for (item in a){
            println(":\$\item ") //      0,1,2,3,4
        }

        // 使用 step 指定步长
        val b = 1..10 step 3
        for (item in b){
            println(":\$\item ") //      1,4,7,10
        }

        val c = 10 downTo 1 step 2
        for (item in c){
            println(":\$\item ") //      10,8,6,4,2
        }

        // 使用 until 函数排除结束元素
        val d = 1 until 9
        for (i in d) {   //
            print("$\i,") // 1,2,3,4,5,6,7,8
        }
        println("😄😄")

            """)

    }
}