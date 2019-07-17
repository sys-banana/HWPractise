package com.example.zhangzhuang.notification.router;

import android.app.Application;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.example.zhangzhuang.notification.R;

public class AActivity extends AppCompatActivity {

    private Button btn_a;
    private Application application;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aactivity);

        btn_a = findViewById(R.id.btn_a);
        application = getApplication();
//
        ARouter.openLog();// 打印日志
        ARouter.openDebug();// 开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
        ARouter.init(application);

        btn_a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ARouter.getInstance().build("/test/activity")
                        .withString("name","8888")
                        .withInt("age",11)
                        .navigation();
            }
        });




    }
}
