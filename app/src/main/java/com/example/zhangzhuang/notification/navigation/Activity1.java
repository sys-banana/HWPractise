package com.example.zhangzhuang.notification.navigation;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.example.zhangzhuang.notification.R;
import com.example.zhangzhuang.notification.util.ToastUtil;

public class Activity1 extends AppCompatActivity {

    private BottomNavigationBar navigation_bottom;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity1);


        navigation_bottom=findViewById(R.id.navigation_bottom);

        navigation_bottom.addItem(new BottomNavigationItem(R.drawable.ic_assets,"one"))
                .addItem(new BottomNavigationItem(R.drawable.ic_assets,"two"))
                .addItem(new BottomNavigationItem(R.drawable.ic_assets,"three"))
                .addItem(new BottomNavigationItem(R.drawable.ic_assets,"four"))
                .addItem(new BottomNavigationItem(R.drawable.ic_assets,"four"))
                .addItem(new BottomNavigationItem(R.drawable.ic_assets,"four"))
                .addItem(new BottomNavigationItem(R.drawable.ic_assets,"four"))
                .addItem(new BottomNavigationItem(R.drawable.ic_assets,"four"))
                .addItem(new BottomNavigationItem(R.drawable.ic_assets,"four"))
                .setFirstSelectedPosition(0)
                .setMode(BottomNavigationBar.MODE_FIXED)
                .setActiveColor(R.color.colorAccent)
                .setInActiveColor(R.color.colorPrimary)
                .initialise();

        navigation_bottom.setTabSelectedListener(new BottomNavigationBar.OnTabSelectedListener() {
            @Override
            public void onTabSelected(int position) {
                ToastUtil.showToast(Activity1.this,"选中"+position);
            }

            @Override
            public void onTabUnselected(int position) {

            }

            @Override
            public void onTabReselected(int position) {

            }
        });


    }
}
