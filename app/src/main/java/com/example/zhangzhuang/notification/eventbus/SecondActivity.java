package com.example.zhangzhuang.notification.eventbus;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.zhangzhuang.notification.R;

import org.greenrobot.eventbus.EventBus;

public class SecondActivity extends AppCompatActivity {
    private Button mbtn;
    private Button mbtn2;
    private Button mbtn3;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);
        mbtn = findViewById(R.id.btn);
        mbtn2 = findViewById(R.id.btn2);
        mbtn3 = findViewById(R.id.btn3);

        jumpActivity();
    }

    private void jumpActivity(){
        mbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EventBus.getDefault().post(new MessageEvent("欢迎大家光临我的博客"));
                finish();
            }
        });
        mbtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EventBus.getDefault().post(new MessageEvent("欢迎大家光临我的博客2"));
                finish();
            }
        });
        mbtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EventBus.getDefault().post(new MessageEvent("欢迎大家光临我的博客3"));
                finish();
            }
        });


    }
}
