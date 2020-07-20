
package com.example.xiaobao.xiaobaokotlin.home13.day11;

/**
 * Created by xiaobao on 2020/7/16.
 */


// java 单例
public class Settingmanager_java {

    public static final Settingmanager_java INSTANCE;

    String name;
    Integer age;

    public Settingmanager_java(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public final void calculate() {

        System.out.println("calculate-------");
    }

    public Settingmanager_java() {
    }

    static {
        Settingmanager_java var0 = new Settingmanager_java();
        INSTANCE = var0;
    }


    @Override
    public String toString() {
        return "Settingmanager_java{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}


// 饿汉式单例
  class Singleton1 {
    // 私有构造
    private Singleton1() {}

    private static Singleton1 single = new Singleton1();

    // 静态工厂方法
    public static Singleton1 getInstance() {
        return single;
    }
}



// 懒汉式单例
//该示例虽然用延迟加载方式实现了懒汉式单例，但在多线程环境下会产生多个single对象，
 class Singleton2 {
    // 私有构造
    private Singleton2() {}
    private static Singleton2 single = null;
    public static Singleton2 getInstance() {
        if(single == null){
            single = new Singleton2();
        }
        return single;
    }
}


//使用synchronized同步锁
//在方法上加synchronized同步锁或是用同步代码块对类加同步锁，此种方式虽然解决了多个实例对象问题，但是该方式运行效率却很低下，下一个线程想要获取对象，就必须等待上一个线程释放锁之后，才可以继续运行
 class Singleton3 {
    // 私有构造
    private Singleton3() {}

    private static Singleton3 single = null;

    public static Singleton3 getInstance() {

        // 等同于 synchronized public static Singleton3 getInstance()
        synchronized(Singleton3.class){
            // 注意：里面的判断是一定要加的，否则出现线程安全问题
            if(single == null){
                single = new Singleton3();
            }
        }
        return single;
    }
}



//使用双重检查进一步做了优化，可以避免整个方法被锁，只对需要锁的代码部分加锁，可以提高执行效率。
// 这种只会在第一次初始化的时候加锁，
class Singleton4 {
    // 私有构造
    private Singleton4() {}

    private static Singleton4 single = null;

    // 双重检查
    public static Singleton4 getInstance() {
        if (single == null) {
            synchronized (Singleton4.class) {
                if (single == null) {
                    single = new Singleton4();
                }
            }
        }
        return single;
    }
}



// 静态内部类实现
//静态内部类虽然保证了单例在多线程并发下的线程安全性，
// 但是在遇到序列化对象时，默认的方式运行得到的结果就是多例的。这种情况不多做说明了，使用时请注意
class Singleton5 {
    // 私有构造
    private Singleton5() {}

    // 静态内部类
    private static class InnerObject{
        private static Singleton5 single = new Singleton5();
    }

    public static Singleton5 getInstance() {
        return InnerObject.single;
    }
}



//  static静态代码块实现
class Singleton6 {

    // 私有构造
    private Singleton6() {}

    private static Singleton6 single = null;

    // 静态代码块
    static{
        single = new Singleton6();
    }

    public static Singleton6 getInstance() {
        return single;
    }
}



 class SingletonFactory {

    // 内部枚举类
    private enum EnmuSingleton{
        Singleton;
        private Singleton8 singleton;

        //枚举类的构造方法在类加载是被实例化
        private EnmuSingleton(){
            singleton = new Singleton8();
        }
        public Singleton8 getInstance(){
            return singleton;
        }
    }
    public static Singleton8 getInstance() {
        return EnmuSingleton.Singleton.getInstance();
    }
}

class Singleton8{
    public Singleton8(){}
}









