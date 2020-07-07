package com.example.xiaobao.xiaobaokotlin.home5.day3.json_model;

/**
 * Created by xiaobao on 2020/6/20.
 */

public class SchoolInfo {
    public String getSchool_name() {
        return school_name;
    }

    public void setSchool_name(String school_name) {
        this.school_name = school_name;
    }

    private String school_name;

    @Override
    public String toString() {
        return "SchoolInfo{" +
                "school_name='" + school_name + '\'' +
                '}';
    }
}
