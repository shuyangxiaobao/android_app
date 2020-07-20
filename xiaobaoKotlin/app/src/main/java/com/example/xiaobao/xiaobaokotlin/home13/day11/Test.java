package com.example.xiaobao.xiaobaokotlin.home13.day11;

/**
 * Created by xiaobao on 2020/7/16.
 */

public class Test {

    public void demo1() {
        Latitude latitude = Latitude.ofDouble(3.0);
        Latitude latitude1 = Latitude.ofLatitude(latitude);
        String tag = Latitude.TAG;
        System.out.println("tag="+tag);

        Settingmanager.INSTANCE.setName("xiaoming");
        Settingmanager.INSTANCE.setOpen(true);

    }

    // 使用kotlin 单例
    public void demo2() {
        String name = Settingmanager.INSTANCE.getName();
        Boolean open = Settingmanager.INSTANCE.getOpen();
        System.out.println(name+open+"😄😄😄😄😄😄😄😄😄");
    }



    // 使用java单例
    public  void demo3(){
        String name = Settingmanager_java.INSTANCE.name;
        System.out.println(name);

        Settingmanager_java xiaoming = new Settingmanager_java("xiaoming", 198);
        System.out.println(xiaoming);

        Singleton1.getInstance();

    }
}



