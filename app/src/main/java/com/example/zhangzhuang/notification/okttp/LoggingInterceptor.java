package com.example.zhangzhuang.notification.okttp;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class LoggingInterceptor implements Interceptor {
    @NotNull
    @Override
    public Response intercept(@NotNull Chain chain) throws IOException {
        Request request = chain.request();

        long startTime = System.nanoTime();
        System.out.println(String.format("Sending request %s on %s%n%s",
                request.url(),chain.connection(),request.headers()));

        Response response = chain.proceed(request);
        long endTime = System.nanoTime();

        System.out.println(String.format("Received response for %s in %.1fms%n%s",
                response.request().url(), (endTime - startTime) / 1e6d, response.headers()));

        return response;
    }
}
