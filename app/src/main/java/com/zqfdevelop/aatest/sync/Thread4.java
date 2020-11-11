package com.zqfdevelop.aatest.sync;

/**
 * Create by zqf 2020/9/1
 * class desc
 */
public class Thread4 extends Thread {
    private Task mTask;

    public Thread4(Task tk) {
        mTask = tk;
    }

    @Override
    public void run() {
        mTask.doTaskD();
    }
}
