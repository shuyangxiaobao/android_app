package com.example.xiaobao.xiaobaokotlin.home13.day8

/**
 * Created by xiaobao on 2020/7/15.
 */


//子类有主构造函数
open class Person(var name: String, var age: Int) {
    // 基类
   open fun study(){
        println("我毕业了")
    }

}

class Student(name: String, age: Int, var no: String, var score: Int) : Person(name, age) {

}


class Student2 : Person {
    /**次级构造函数**/
    constructor(name: String, age: Int, no: String, score: Int) : super(name, age) {

    }

    override fun study() {
        super.study()
        println("重写了 study")
    }

}
