package com.example.xiaobao.xiaobaokotlin.home13.day7

/**
 * Created by xiaobao on 2020/7/13.
 */
class Runoob {

    // 属性的set 和 get 方法
    var name: String? = null
        get() = field + "添加"
        set(value) {
            field = value;
        }

    var age: Int? = null


//    使用次构造器
    constructor(name: String?, age: Int?) {
        this.name = name
        this.age = age
    }




    fun demo1(): Unit {
        println("我是成员函数 demo1")
    }

    override fun toString(): String {
        return "Runoob(name=$name, age=$age)"
    }


}


// 使用主构造器
class Runoob2  constructor(name: String) {  // 类名为 Runoob
    // 大括号内是类体构成
    var url: String = "http://www.runoob.com"
    var country: String = "CN"
    var siteName = name

    constructor(name: String,country:String) : this(name){

    }

    // 次构造函数
    constructor (name: String, alexa: Int) : this(name) {
        println("Alexa 排名 $alexa")
    }



    init {
        println("初始化网站名: ${name}")
    }


    fun printTest() {
        println("我是类的函数")
    }
}


class Runoob3  constructor(name: String) {  // 类名为 Runoob
    // 大括号内是类体构成
    var url: String = "http://www.runoob.com"
    var country: String = "CN"
    var siteName = name

    init {
        println("初始化网站名: ${name}")
    }


    // 次构造函数
    constructor (name: String, alexa: Int) : this(name) {
        println("Alexa 排名 $alexa")
    }



    fun printTest() {
        println("我是类的函数")
    }
}
