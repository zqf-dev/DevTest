package com.zqfdevelop.aatest;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.concurrent.BlockingQueue;

/**
 * Create by zqf 2020/9/2
 * class desc 消费窗口--->从请求队列中拿到具体信息做具体请求图片下来
 */
public class BitmapDispatherThread extends Thread {

    private BlockingQueue<BitmapRequest> requestsQueue;
    private Handler handler = new Handler(Looper.getMainLooper());

    public BitmapDispatherThread(BlockingQueue<BitmapRequest> requestsQueue) {
        this.requestsQueue = requestsQueue;
    }

    @Override
    public void run() {
        while (!isInterrupted()) {
            try {
                BitmapRequest request = requestsQueue.take();
                //占位图显示
                showLoadResImg(request);
                //请求网络图片
                Bitmap bitmap = httpRequestBitmap(request);
                //显示
                showLoadHttpImg(bitmap, request);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //请求图片
        }
    }

    private void showLoadHttpImg(final Bitmap bitmap, final BitmapRequest request) {
        Log.e("Tag", "showLoadHttpImg");
        if (bitmap != null && request.getImage() != null && request.getImage().getTag().equals(request.getUrlMd5())) {
            handler.post(new Runnable() {
                @Override
                public void run() {
                    Log.e("Tag", "load");
                    request.getImage().setImageBitmap(bitmap);
                }
            });
        }
    }

    private Bitmap httpRequestBitmap(BitmapRequest request) {
        return downloadBitmap(request.getUrl());
    }

    private Bitmap downloadBitmap(String url) {
        InputStream is = null;
        Bitmap bitmap = null;
        try {
            URL url1 = new URL(url);
            HttpURLConnection conn = (HttpURLConnection) url1.openConnection();
            // 设置请求类型为Get类型
            conn.setRequestMethod("GET");
            // 判断请求Url是否成功
            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("请求url失败");
            }
            is = conn.getInputStream();
            bitmap = BitmapFactory.decodeStream(is);
            Log.e("Tag", "200");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return bitmap;
    }


    private void showLoadResImg(BitmapRequest request) {
        final ImageView imageView = request.getImage();
        final int resId = request.getLoadResId();
        if (resId > 0) {
            handler.post(new Runnable() {
                @Override
                public void run() {
                    imageView.setImageResource(resId);
                }
            });
        }
    }
}
