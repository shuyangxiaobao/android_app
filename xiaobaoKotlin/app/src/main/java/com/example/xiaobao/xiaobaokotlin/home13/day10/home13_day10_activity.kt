package com.example.xiaobao.xiaobaokotlin.home13.day10

import android.app.Activity
import android.os.Bundle
import android.widget.TextView
import com.example.xiaobao.xiaobaokotlin.R

/**
 * Created by xiaobao on 2020/7/9.
 */
class home13_day10_activity : Activity() {

    var textView: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home13_day10_firstview)
        textView = findViewById(R.id.textView)
        demo1()

        val u1 = MyUser("xiaoming");


//        扩展函数
        fun MyUser.demotest(age:Int):Int {
            println("扩展类")
            return  age + 5;
        }


       var age =  u1.demotest(10);
        println("age=$age")


    }


    fun demo1(): Unit {


        textView?.setText("""
       13.扩展函数

            """)

    }
}