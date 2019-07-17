package com.example.zhangzhuang.notification;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class FragmentActivity extends AppCompatActivity implements HeadlinesFragment.OnHeadlinesSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);

        if (findViewById(R.id.fragment_container)!=null){
            if (savedInstanceState!=null){
                return;
            }

            ArticleFragment fragment = new ArticleFragment();

            fragment.setArguments(getIntent().getExtras());

            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragment_container,fragment).commit();
        }
    }


    @Override
    public void onArticleSelected(int position) {

        ArticleFragment articleFragment = (ArticleFragment)
                getSupportFragmentManager().findFragmentById(R.id.fragment_container);

        if (articleFragment!=null){
        }else {
            ArticleFragment newFragment = new ArticleFragment();
            Bundle args = new Bundle();
        }

    }
}
