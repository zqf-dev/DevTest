package com.zqfdevelop.aatest.sync;

/**
 * Create by zqf 2020/9/1
 * class desc
 */
public class Thread2 extends Thread {
    public Task task;

    public Thread2(Task task) {
        this.task = task;
    }

    @Override
    public void run() {
        task.doTaskB();
    }
}
