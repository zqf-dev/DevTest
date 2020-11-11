package com.zqfdevelop.aatest.sync;

/**
 * Create by zqf 2020/9/1
 * class desc
 */
public class Thread3 extends Thread {
    private Task mTask;

    public Thread3(Task tk) {
        mTask = tk;
    }

    @Override
    public void run() {
        mTask.doTaskC();
    }
}
