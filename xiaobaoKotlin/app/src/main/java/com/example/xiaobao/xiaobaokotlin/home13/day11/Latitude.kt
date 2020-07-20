package com.example.xiaobao.xiaobaokotlin.home13.day11

/**
 * Created by xiaobao on 2020/7/16.
 */


// kotlin 静态方法 静态变量
class Latitude private constructor(val value:Double){
    companion object {

        @JvmStatic
        fun ofDouble(dou:Double): Latitude {
            return Latitude(dou)
        }
        @JvmStatic
        fun ofLatitude(latitude: Latitude): Latitude {
            return Latitude(latitude.value)
        }

        @JvmField
        val TAG:String = "latitude"

    }
}