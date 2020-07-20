package com.example.xiaobao.xiaobaokotlin.home13.day9

/**
 * Created by xiaobao on 2020/7/15.
 */

//使用 interface 关键字定义接口，允许方法有默认实现：
interface MyInterface {
    var name:String //name 属性, 抽象的

    fun demo1()
    fun demo2(){
        print("demo2---MyInterface")
    }
}

interface MyInterface2 {
    fun demo1()
    fun demo2(){
        print("demo2--MyInterface2")
    }
    fun demo3()
    fun demo4(){
        print("demo4")
    }
}


//  实现接口  一个类或者对象可以实现一个或多个接口。
class Child :MyInterface,MyInterface2{
    // 属性的set 和 get 方法
    override var name: String = ""
        get() = field + "添加"
        set(value) {
            field = value;
        }

    var age: Int? = null


    override fun demo1() {

        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun demo2() {
        super<MyInterface>.demo2()
        super<MyInterface2>.demo2()

    }

    override fun demo3() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun demo4() {
        super.demo4()
    }
}