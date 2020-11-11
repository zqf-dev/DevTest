package com.zqfdevelop.aatest.sync;

/**
 * Create by zqf 2020/9/1
 * class desc
 */
public class SynchroizedTest {

    public static void main(String[] args) {
        Task taskA = new Task();//A对象
        Task taskB = new Task();//B对象

        //多个线程同时执行不同的实例对象里的方法时
        Thread t1 = new Thread1(taskA);
        Thread t2 = new Thread1(taskA);
//        Thread t1 = new Thread2(taskA);
//        Thread t2 = new Thread2(taskB);
        t1.setName("t1");
        t2.setName("t2");
        t1.start();
        t2.start();
        //结论：多个线程持有多个对象实例，执行对象的同步方法，不会按顺序同步执行，因为JVM分配了不同的锁


//        Thread t1 = new Thread3(taskA);
//        Thread t2 = new Thread3(taskB);
//        Task taskC = new Task();//B对象
//        Thread t3 = new Thread4(taskC);
//        Thread t4 = new Thread4(taskC);
//        t3.setName("t3");
//        t4.setName("t4");
//        t3.start();
//        t4.start();
        //结论：多个线程持有一个类锁，排队执行，持有就是王者，否则就排队等待


    }
}
