package com.example.zhangzhuang.notification.okttp;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
//同不get请求
public class OkttpTest2 {
    public static void main(String[] args) {
        String url = "http://www.baidu.com";
        OkHttpClient okHttpClient = new OkHttpClient();
        final Request request = new Request.Builder()
                .url(url)
                .build();
        final Call call = okHttpClient.newCall(request);
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Response response = call.execute();
                    System.out.println("run:"+response.body().string());
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
