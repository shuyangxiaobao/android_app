package com.example.xiaobao.xiaobaokotlin.home13.day2

import android.app.Activity
import android.os.Bundle
import com.example.xiaobao.xiaobaokotlin.R

/**
 * Created by xiaobao on 2020/7/8.
 */
class home13_day2_activity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home13_day2_firstview)
//        demo1()
//        demo2()
//        demo3()
//        demo4()
        demo5();

    }


    fun demo1(): Unit {
        var a = 1
        var b = 2
// 模板中的简单名称：
        val s1 = "a+b is ${a + b}"    // a is 1
        a = 2
// 模板中的任意表达式：
        val s2 = "${s1.replace("is", "was")}, but now is $a" // a was a,but now is 2
        println("s2:$s2")
    }

    fun demo2(): Unit {
        //类型后面加?表示可为空
        var age: String? = null
//抛出空指针异常
//        val ages = age!!.toInt()

//不做处理返回 null
        val ages1 = age?.toInt() ?: 0

//age为空返回-1
        val ages2 = age?.toInt() ?: -1
        println("")

        val value: String? = null
        println("xlpxlp" + value)

        var str2 = value ?: "1234"
        println(str2);

    }

    fun demo3(): Unit {

        if (true) {
            //  智能类型转换
            var person: Person? = Child("")
            var t = (person as? Child)?.name ?: "123"
            println(t)
            if (person is Child) {
                println("xlpxlp:" + person.name)
            }
        }


        // 安全类型转换
        var person: Person? = Child();
        var person2: Child? = person as? Child
        var xlp = (person as? Child)?.name as? Child ?: "morenzjo"
        println(xlp)

    }

    fun demo4(): Unit {
        var name: String? = null
        val arr:MutableList<Int>? = mutableListOf()
        arr?.add(name?.toInt() ?: 99)
        println(arr)
        arr?.add(name!!.toInt()) // 报错
        println(arr)
    }


    // as?  as
    fun demo5(): Unit {
        var person:Person? = Person()
        (person as? Child)?.name    //ok
        (person as Child).name  //奔溃
    }


}