package com.example.zhangzhuang.notification.okttp;

import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
//提交表单
public class OkttpTest6 {
    public static void main(String[] args) {
        OkHttpClient okHttpClient = new OkHttpClient();
        RequestBody requestBody = new FormBody.Builder()
                .add("search","zhangzhuang")
                .build();
        Request request = new Request.Builder()
                .url("https://api.github.com/markdown/raw")
                .post(requestBody)
                .build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                System.out.println("onFailure:"+e.getMessage());
            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                System.out.println(response.protocol()+" "+response.code()+""+response.message());
                Headers headers = response.headers();
                for (int i = 0;i<headers.size();i++){
                    System.out.println(headers.name(i)+":"+headers.value(i));
                }
                System.out.println("onrespose:"+response.body().string());
            }
        });
    }
}
