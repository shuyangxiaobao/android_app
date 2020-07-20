package com.example.xiaobao.xiaobaokotlin.home13.day13

import android.app.Activity
import android.os.Bundle
import android.widget.TextView
import com.example.xiaobao.xiaobaokotlin.R
import com.example.xiaobao.xiaobaokotlin.home13.day12.Example

/**
 * Created by xiaobao on 2020/7/9.
 */
class home13_day13_activity : Activity() {

    var textView: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home13_day13_firstview)
        textView = findViewById(R.id.textView)
        demo1()
        demo2()
    }


    fun getAnimalName(animal: Animal): String = when (animal) {
        is Bird -> "鸟类：" + animal.name
        is Fish -> "鱼类：" + animal.name
    }

    //  Kotlin密封类
    fun demo2(): Unit {
        val animalName = getAnimalName(Fish("鲨鱼"))

        var animalName2 = getAnimalName(Bird("麻雀"))
        println(animalName)
        println(animalName2)

    }


    // 数据类
    fun demo1(): Unit {
        var tom = User("tom", 28)
        var oldTom = tom.copy("oldtom")
        println(tom)
        println(oldTom)

        var (name, age) = User("jane", 16)
        println("name=$name,  age=$age");   //  name=jane,  age=16


        textView?.setText("""

            """)

    }
}