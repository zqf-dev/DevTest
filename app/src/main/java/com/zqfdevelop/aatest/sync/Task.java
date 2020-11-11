package com.zqfdevelop.aatest.sync;

/**
 * Create by zqf 2020/9/1
 * class desc
 */
public class Task {

    public synchronized void doTaskA() {
        System.out.println("name = " + Thread.currentThread().getName() + ", begain");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("name = " + Thread.currentThread().getName() + ", end");
    }

    public void doTaskB() {
        synchronized (Task.class) {
            System.out.println("name = " + Thread.currentThread().getName() + ", begain");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("name = " + Thread.currentThread().getName() + ", end");
        }
    }

    //-------------------------------类锁----------------------------------------------
    public synchronized static void doTaskC() {
        System.out.println("name = " + Thread.currentThread().getName() + ", begain");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("name = " + Thread.currentThread().getName() + ", end");
    }

    public static void doTaskD() {
        synchronized (Task.class) {// Class对象
            System.out.println("name = " + Thread.currentThread().getName() + ", begain");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("name = " + Thread.currentThread().getName() + ", end");
        }
    }
}
