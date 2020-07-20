package com.example.xiaobao.xiaobaokotlin.home13.day5

import android.app.Activity
import android.os.Bundle
import android.widget.TextView
import com.example.xiaobao.xiaobaokotlin.R

/**
 * Created by xiaobao on 2020/7/9.
 */
class home13_day5_activity:Activity() {

    var textView:TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home13_day3_firstview)
        textView = findViewById(R.id.textView)
        demo1()

    }

    fun demo2(): Unit {
        
    }


    fun demo1(): Unit {

//        val c = if (condition) a else b
        var x = 0
        if(x>0){
            println("x 大于 0")
        }else if(x==0){
            println("x 等于 0")
        }else{
            println("x 小于 0")
        }

        var a = 1
        var b = 2
        val c = if (a>=b) a else b
        println("c 的值为 $c")


        //使用区间
        val x2 = 5
        val y2 = 9
        if (x2 in 1..8) {
            println("x 在区间内")
        }

        // When 表达式
        // when 类似其他语言的 switch 操作符。其最简单的形式如下：

        when (x) {
            1 -> print("x == 1")
            2 -> print("x == 2")
            3,4 -> print("3,4")
            in 5..10 ->{
                print("5到10")
            }
            else -> { // 注意这个块
                println("ppppp")
            }
        }

        // when 中使用 in 运算符来判断集合内是否包含某实例：
        val items = setOf("apple", "banana", "kiwi","orange")
        when {
            "apple" in items -> println("apple is fine too")
            "orange" in items -> println("orange")
        }


        textView?.setText("""
   //        val c = if (condition) a else b
        var x = 0
        if(x>0){
            println("x 大于 0")
        }else if(x==0){
            println("x 等于 0")
        }else{
            println("x 小于 0")
        }

        var a = 1
        var b = 2
        val c = if (a>=b) a else b
        println("c 的值为 $c")


        //使用区间
        val x2 = 5
        val y2 = 9
        if (x2 in 1..8) {
            println("x 在区间内")
        }

        // When 表达式
        // when 类似其他语言的 switch 操作符。其最简单的形式如下：

        when (x) {
            1 -> print("x == 1")
            2 -> print("x == 2")
            3,4 -> print("3,4")
            in 5..10 ->{
                print("5到10")
            }
            else -> { // 注意这个块
                println("ppppp")
            }
        }

        // when 中使用 in 运算符来判断集合内是否包含某实例：
        val items = setOf("apple", "banana", "kiwi","orange")
        when {
            "apple" in items -> println("apple is fine too")
            "orange" in items -> println("orange")
        }

            """)

    }
}