package com.example.xiaobao.xiaobaokotlin.home13.day12

import kotlin.reflect.KProperty

/**
 * Created by xiaobao on 2020/7/18.
 */
class Example {
    var name: String by Delegate()
}
class Delegate {
    var value:String? = null
    operator fun getValue(thisRef: Any?, property: KProperty<*>): String {
        println("getvalue.........")
        return value?: "";
//        return "$thisRef, thank you for delegating '${property.name}' to me!"
    }

    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: String) {
        println("$value has been assigned to '${property.name}' in $thisRef.")
        println("setValue.......")
        this.value = value;
    }
}
