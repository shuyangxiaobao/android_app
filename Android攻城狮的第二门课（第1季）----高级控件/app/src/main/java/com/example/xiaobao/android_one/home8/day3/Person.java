package com.example.xiaobao.android_one.home8.day3;

import java.io.Serializable;

/**
 * Created by xiaobao on 2020/7/1.
 */

public class Person implements Serializable {
    private String address;
    private int age;
    private String name;

    public Person(String address, int age, String name) {
        this.address = address;
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "address='" + address + '\'' +
                ", age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
