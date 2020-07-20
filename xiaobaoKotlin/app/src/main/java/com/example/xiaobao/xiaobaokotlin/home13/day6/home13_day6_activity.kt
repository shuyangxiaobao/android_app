package com.example.xiaobao.xiaobaokotlin.home13.day6

import android.app.Activity
import android.os.Bundle
import android.widget.TextView
import com.example.xiaobao.xiaobaokotlin.R

/**
 * Created by xiaobao on 2020/7/9.
 */
class home13_day6_activity:Activity() {

    var textView:TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home13_day3_firstview)
        textView = findViewById(R.id.textView)
        demo1()

    }


    fun demo1(): Unit {
        // For 循环
        val items = listOf("ios","android","html","flutter")
        println("00000000")
        for (item in items){
            println(item)
        }

        println("11111111")
        for (i in items.indices){
            println(items[i]);
        }

        println("2222222")
        for ((index,value) in items.withIndex()){
            println("$index : $value")
        }


        println("START : ")
        outer@ for (out in 1..5) {
            println("outer $out")
            for (inner in 1..5) {
                if (inner % 2 == 0) {
                    break@outer
                }
                println("inner $inner")
            }
        }
        println(" END : ")

        // while 与 do...while 循环
/**
        while( 布尔表达式 ) {
            //循环内容
        }

        do {
            //代码语句
        }while(布尔表达式);

**/


        textView?.setText("""


            """)

    }
}