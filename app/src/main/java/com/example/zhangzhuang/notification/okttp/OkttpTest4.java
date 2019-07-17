package com.example.zhangzhuang.notification.okttp;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okio.BufferedSink;
//提交流
public class OkttpTest4 {
    public static void main(String[] args) {
      RequestBody requestBody = new RequestBody() {
          @Nullable
          @Override
          public MediaType contentType() {
              return MediaType.parse("text/x-markdown; charset=utf-8");
          }

          @Override
          public void writeTo(@NotNull BufferedSink bufferedSink) throws IOException {
              bufferedSink.writeUtf8("i am jdpm");
          }
      };

      Request request = new Request.Builder()
              .url("https://api.github.com/markdown/raw")
              .post(requestBody)
              .build();

      OkHttpClient okHttpClient = new OkHttpClient();
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
