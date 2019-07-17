package com.example.zhangzhuang.notification;

import android.app.ListFragment;
import android.content.Context;

public class HeadlinesFragment extends ListFragment {

    private OnHeadlinesSelectedListener mCallback;

    public interface OnHeadlinesSelectedListener{
        public void onArticleSelected(int position);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            mCallback = (OnHeadlinesSelectedListener)context;
        }catch (ClassCastException e){
            throw new ClassCastException(context.toString()
            +"must implement OnHeadlineSelectedListener");
        }


    }
}
