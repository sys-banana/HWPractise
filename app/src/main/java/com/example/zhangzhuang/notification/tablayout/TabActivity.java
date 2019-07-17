package com.example.zhangzhuang.notification.tablayout;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.zhangzhuang.notification.R;

import java.util.ArrayList;
import java.util.List;

public class TabActivity extends AppCompatActivity {

    private TabLayout mTabLayout;
    private String[] mTitles = {"未支付账单","支付中账单","历史账单"};
    private ViewPager mViewPager;
    private MyFragmentPagerAdapter mAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab);

        mTabLayout = findViewById(R.id.tl_main);
        mViewPager = findViewById(R.id.vp_main);
        addTabToTabLayout();
        setupWithViewPager();

    }

    private void addTabToTabLayout(){

        for (int i = 0;i<mTitles.length;i++){
//            mTabLayout.addTab(mTabLayout.newTab().setText(mTitles[i]));
            mTabLayout.addTab(mTabLayout.newTab().setText(mTitles[i]).setIcon(R.drawable.ic_assets));
        }
    }

    private void setupWithViewPager(){
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(new FirstFragment());
        fragments.add(new TwoFragment());
        fragments.add(new ThreeFragment());

        mAdapter = new MyFragmentPagerAdapter(getSupportFragmentManager());
        mAdapter.addTitlesAndFragments(mTitles,fragments);

        mViewPager.setAdapter(mAdapter);
        mTabLayout.setupWithViewPager(mViewPager);

    }
}
