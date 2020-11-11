package com.zqfdevelop.aatest;

import android.content.Context;

/**
 * Create by zqf 2020/9/2
 * class desc
 */
public class MyGlide {

    public static BitmapRequest with(Context context) {
        return new BitmapRequest(context);
    }
}
