package com.zqfdevelop.aatest;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * Create by zqf 2020/9/2
 * class desc
 */
public class RequestManager {

    private static RequestManager instance;

    private LinkedBlockingQueue<BitmapRequest> requestQueue = new LinkedBlockingQueue<>();

    public void add(BitmapRequest bitmapRequest) {
        if (!requestQueue.contains(bitmapRequest)) {
            requestQueue.add(bitmapRequest);
        }
    }

    private RequestManager() {
        createDispatch();
    }

    public static RequestManager getInstance() {
        if (instance == null) {
            instance = new RequestManager();
        }
        return instance;
    }

    private BitmapDispatherThread[] dispathers;

    private void createDispatch() {
        int threadCount = Runtime.getRuntime().availableProcessors();
        dispathers = new BitmapDispatherThread[threadCount];
        for (int i = 0; i < dispathers.length; i++) {
            BitmapDispatherThread bitmapDispather = new BitmapDispatherThread(requestQueue);
            bitmapDispather.start();
            dispathers[i] = bitmapDispather;
        }
    }
}
