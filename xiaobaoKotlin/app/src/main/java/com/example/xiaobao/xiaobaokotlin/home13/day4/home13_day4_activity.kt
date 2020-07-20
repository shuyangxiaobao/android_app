package com.example.xiaobao.xiaobaokotlin.home13.day4

import android.app.Activity
import android.os.Bundle
import android.widget.TextView
import com.example.xiaobao.xiaobaokotlin.R
import kotlin.math.log10

/**
 * Created by xiaobao on 2020/7/9.
 */
class home13_day4_activity:Activity() {

    var textView:TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home13_day3_firstview)
        textView = findViewById(R.id.textView)
        demo1()

    }


    fun demo1(): Unit {
        val you = '你'
        println(you.toInt())
        var  one:Char? = '1'
//        one = "23" as? Char

        // 查看某个字符的编码
        println(one?.toInt()) //  49

        if (one in '0'..'9'){
            println("是数字")
        }

        one = 'B'
        if (one in 'A'..'a'){
            println("是字母")
        }

        for (item in 49..120){
            print(item.toChar()+",") //1,2,3,4,5,6,7,8,9,:,;,<,=,>,?,@,A,B,C,D,E,F,G,H,I,J,K,L,M,N,O,P,
        }

        textView?.setText("""
                val you = '你'
        println(you.toInt())
        var  one:Char? = '1'
//        one = "23" as? Char

        // 查看某个字符的编码
        println(one?.toInt()) //  49

        if (one in '0'..'9'){
            println("是数字")
        }

        one = 'B'
        if (one in 'A'..'a'){
            println("是字母")
        }

        for (item in 49..120){
            print(item.toChar()+",") //1,2,3,4,5,6,7,8,9,:,;,<,=,>,?,@,A,B,C,D,E,F,G,H,I,J,K,L,M,N,O,P,
        }
            """)

    }
}