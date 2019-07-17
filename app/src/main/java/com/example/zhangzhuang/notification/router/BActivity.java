package com.example.zhangzhuang.notification.router;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.example.zhangzhuang.notification.R;
@Route(path = "/test/activity")
public class BActivity extends AppCompatActivity {

    @Autowired
    public String name;
    @Autowired(name="age")
    int age;
    private TextView tv_b;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bactivity);
        tv_b = findViewById(R.id.tv_b);

        ARouter.getInstance().inject(this);

        tv_b.setText(name+"---"+age);
    }
}
