package com.example.zhangzhuang.notification.okttp;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
//post方式提交string
public class OkttpTest3 {
    public static void main(String[] args) {
        MediaType mediaType = MediaType.parse("text/x-markdown; charset=utf-8");
        String requestBody = "i am jdpm.";
        Request request = new Request.Builder()
                .url("https://api.github.com/markdown/raw")
                .post(RequestBody.create(mediaType,requestBody))
                .build();
        OkHttpClient okHttpClient = new OkHttpClient();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                System.out.println("onfailure:"+e.getMessage());
            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                System.out.println(response.protocol()+"---"+response.code()+"---"+response.message());
                System.out.println("+++++++++++++++++++++++");
                Headers headers = response.headers();
                for (int i = 0;i<headers.size();i++){
                    System.out.println(headers.name(i)+":"+headers.value(i));
                    System.out.println("------------------------");
                }
                System.out.println("+++++++++++++++++++++++");
                System.out.println("onresponse:"+response.body().string());
            }
        });
    }
}
