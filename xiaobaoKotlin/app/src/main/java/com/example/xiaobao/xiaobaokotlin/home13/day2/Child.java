package com.example.xiaobao.xiaobaokotlin.home13.day2;

/**
 * Created by xiaobao on 2020/7/8.
 */

public class Child extends Person {
    public String name;

    public Child() {
    }

    public Child(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Child{" +
                "name='" + name + '\'' +
                '}';
    }
}
