package com.example.xiaobao.android_one.home5.day3.json_model;

import java.util.List;

/**
 * Created by xiaobao on 2020/6/20.
 */

public class Result {
    private int result;
    private List<Person> personData;

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public List<Person> getPersonData() {
        return personData;
    }

    public void setPersonData(List<Person> personData) {
        this.personData = personData;
    }

    @Override
    public String toString() {
        return "Result{" +
                "result=" + result +
                ", personData=" + personData +
                '}';
    }
}
