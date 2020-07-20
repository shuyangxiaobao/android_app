package com.example.xiaobao.xiaobaokotlin.home13.day12

import android.app.Activity
import android.os.Bundle
import android.widget.TextView
import com.example.xiaobao.xiaobaokotlin.R

/**
 * Created by xiaobao on 2020/7/9.
 */
class home13_day12_activity:Activity() {

    var textView:TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home13_day12_firstview)
        textView = findViewById(R.id.textView)
        demo1()

    }


    fun demo1(): Unit {
        val e = Example()
        e.name = "123"
        println(e.name);



        textView?.setText("""

            """)

    }
}