package com.example.xiaobao.xiaobaokotlin.home13.day1

import android.app.Activity
import android.os.Bundle
import android.widget.TextView

import com.example.xiaobao.xiaobaokotlin.R
import java.lang.reflect.Array

/**
 * Created by xiaobao on 2020/7/3.
 */

//class home13_day1_activity : Activity() {
/**
 * Array 创建、增、删、改、查、插入
 * @author lyl 20181228
 * */
class home13_day1_activity : Activity() {

    // 定义Int类型数组
    var itemArr = intArrayOf(1, 2, 3, 4, 5, 6, 7, 8)
    var helloArray: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home13_day1_firstview)
        helloArray = findViewById(R.id.textView)


        // 初始
        helloArray?.text = "初始：" + itemArr.asList().toString() + "\n\n"

        // 添加
        addItem(9)
        helloArray?.text = helloArray?.text as String + "添加：" + itemArr.asList().toString() + "\n\n"

        // 删除
        deleteItem(0)
        helloArray?.text = helloArray?.text as String + "删除：" + itemArr.asList().toString() + "\n\n"

        // 修改
        editItem(0, -1)
        helloArray?.text = helloArray?.text as String + "修改：" + itemArr.asList().toString() + "\n\n"

        // 取值get
        var item: Int = getItem(0)
        helloArray?.text = helloArray?.text as String + "取值：" + item.toString() + "\n\n"

        // 插入
        insertItem(0, -2)
        helloArray?.text = helloArray?.text as String + "插入：" + itemArr.asList().toString() + "\n\n"


        demo1()
    }


    //  数组
    fun demo1(): Unit {
        //表达式：数据类型[]   标识  =   new  数据类型[长度];
        val intArray = IntArray(6)

        //表达式： 数据类型[]  标识  = {value0,value1,...}
        val strArray = arrayOf("value0", "value1")

        //arrayOfNulls<数据类型>(长度)，默认值都是null
        val fixedSizeArr = arrayOfNulls<Int>(6)

        //使用闭包进行初始化
        val arr = Array(3, { it -> it.inc() })//参数1：数组大小，参数2：一个函数参数的工厂函数
        for (i in arr) {
            println(i)
        }

        //创建空数组
        val empty = emptyArray<Int>()

        //访问数组的元素
        for (item in strArray){
            println(item)
        }

        var intArr = intArrayOf(1,2,3);
        for (index in intArr.indices){
            intArr[index]= intArr[index]*2
        }
        for (item in intArr){
            println("xlpxlp $item")
        }

        val arr3:kotlin.Array<String> = arrayOf("xiao","ming","18","age")
        println("arr3="+arr3)
        println(arr3.joinToString("")) // xiaoming

        println(arr3.slice(1..2))
        println(arr3.size)

    }


    /**
     * 增加item
     * @item：需添加数值
     * */
    fun addItem(item: Int) {
        var newArr = IntArray(itemArr.size + 1)
        for (i in itemArr.indices) {
            newArr[i] = itemArr[i]
        }
        newArr[itemArr.size] = item
        itemArr = newArr
    }

    /**
     * 删除item
     * @index：删除位置下标
     * */
    fun deleteItem(index: Int) {
        var newArr = IntArray(itemArr.size - 1)
        for (i in newArr.indices) {
            if (i < index) {
                newArr[i] = itemArr[i]
            } else {
                newArr[i] = itemArr[i + 1]
            }
        }
        itemArr = newArr
    }

    /**
     * 修改item
     * @index：修改位置下标
     * @item：修改后数值
     * */
    fun editItem(index: Int, item: Int) {
        itemArr[index] = item
    }

    /**
     * 获取item
     * @index：获取位置下标
     * */
    fun getItem(index: Int): Int {
        return itemArr[index]
    }

    /**
     * 插入item
     * @index：插入位置下标
     * @item：插入位置数值
     * */
    fun insertItem(index: Int, item: Int) {
        var newArr = IntArray(itemArr.size + 1)
        for (i in itemArr.indices) {
            if (i < index) {
                newArr[i] = itemArr[i]
            } else {
                newArr[i + 1] = itemArr[i]
            }
        }
        newArr[index] = item
        itemArr = newArr
    }

}