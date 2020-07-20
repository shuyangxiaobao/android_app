package com.example.xiaobao.xiaobaokotlin.home13.day11

import android.app.Activity
import android.os.Bundle
import android.widget.TextView
import com.example.xiaobao.xiaobaokotlin.R

/**
 * Created by xiaobao on 2020/7/9.
 */
class home13_day11_activity:Activity() {

    var textView:TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home13_day11_firstview)
        textView = findViewById(R.id.textView)
        demo1()

    }
    fun demo1(): Unit {
        Test().demo1()
        Test().demo2()
        Test().demo3()

        textView?.setText("""

            """)

    }



}