package com.zqfdevelop.aatest;

import android.content.Context;
import android.widget.ImageView;

import java.lang.ref.SoftReference;

/**
 * Create by zqf 2020/9/2
 * class desc
 */
public class BitmapRequest {

    private Context context;
    private String url;
    private SoftReference<ImageView> image;
    private int loadResId;
    private String urlMd5;

    public BitmapRequest(Context context) {
        this.context = context;
    }

    public BitmapRequest url(String url) {
        this.url = url;
        this.urlMd5 = MD5Utils.toMD5(url);
        return this;
    }

    public BitmapRequest loadResId(int loadResId) {
        this.loadResId = loadResId;
        return this;
    }

    public void into(ImageView imageView) {
        this.image = new SoftReference<>(imageView);
        imageView.setTag(urlMd5);
        RequestManager.getInstance().add(this);
    }

    public String getUrl() {
        return url;
    }

    public ImageView getImage() {
        return image.get();
    }


    public int getLoadResId() {
        return loadResId;
    }

    public String getUrlMd5() {
        return urlMd5;
    }

}
