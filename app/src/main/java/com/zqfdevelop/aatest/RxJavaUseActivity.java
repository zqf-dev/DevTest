package com.zqfdevelop.aatest;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.schedulers.Schedulers;

/**
 * Create by zqf 2020/9/3
 * class desc
 */
public class RxJavaUseActivity extends AppCompatActivity {
    ImageView img;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rxjava_use_layout);
        img = findViewById(R.id.rxjava_show_img);
        findViewById(R.id.rxjava_loading_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RxJavaLoading();
            }
        });
    }

    private void RxJavaLoading() {
        //起点
        Observable.just("https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=1138935709,3573339285&fm=26&gp=0.jpg")
                //map部分为具体做的事情，例如：网络请求
                .map(new Function<String, Bitmap>() {
                    @Override
                    public Bitmap apply(String s) throws Throwable {
                        URL url = new URL(s);
                        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                        InputStream is = conn.getInputStream();
                        return BitmapFactory.decodeStream(is);
                    }
                })
                //线程切换 Schedulers.io()切换到子线程做耗时操作（-->例如将map）
                .subscribeOn(Schedulers.io())

                //切换到主线程更新UI
                .observeOn(AndroidSchedulers.mainThread())

                //最终结果:得到Bitmap
                .subscribe(new Observer<Bitmap>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {
                        //开始流向事件分发：可做一些对话框的加载提示
                    }

                    @Override
                    public void onNext(@NonNull Bitmap bitmap) {
                        if (bitmap != null) img.setImageBitmap(bitmap);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
