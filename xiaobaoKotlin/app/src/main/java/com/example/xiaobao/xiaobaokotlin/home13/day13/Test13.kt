package com.example.xiaobao.xiaobaokotlin.home13.day13

/**
 * Created by xiaobao on 2020/7/20.
 */

//Kotlin密封类
sealed class Animal

class Bird(var name: String) : Animal()
class Fish(var name: String) : Animal()