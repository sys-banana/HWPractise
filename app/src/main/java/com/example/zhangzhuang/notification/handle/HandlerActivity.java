package com.example.zhangzhuang.notification.handle;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.zhangzhuang.notification.R;

public class HandlerActivity extends AppCompatActivity {

    TextView mTextView;

    Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 1:
                    mTextView.setText("接收到一条从Worker Thread线程发来空消息");
                    break;
                case 2:
                    mTextView.setText("接收到一条从Worker Thread线程发来指定时间的空消息");
                    break;
                case 3:
                    mTextView.setText("接收到一条从Worker Thread线程发来指定时间之后的空消息");
                    break;
                case 4:
                    String data = (String) msg.obj;
                    mTextView.setText("接收到一条从Worker Thread线程发来消息,消息中包含数据:"+ data);
                    break;
                case 5:
                    String data1 = (String) msg.obj;
                    mTextView.setText("接收到一条从Worker Thread线程发来指定时间的消息,消息中包含数据:" + data1);
                    break;
                case 6:
                    String data2 = (String) msg.obj;
                    mTextView.setText("接收到一条从Worker Thread线程发来指定时间之后消息,消息中包含数据:" + data2);
                    break;

            }
        }
    };

    class WorkerThread extends Thread{
        @Override
        public void run() {
            super.run();
            // 在Worker Thread 向UI Thread 发送一条只有 what 的空消息
            mHandler.sendEmptyMessage(1);

            // 在指定的时间Worker Thread 向UI Thread 发送一条只有 what 的空消息
            mHandler.sendEmptyMessageAtTime(2,SystemClock.uptimeMillis()+1000);

            // 在指定的时间之后Worker Thread 向UI Thread 发送一条只有 what 的空消息
            mHandler.sendEmptyMessageDelayed(3,1000);

            // 创建一个Message
            Message msg1 = new Message();
            msg1.what = 4;
            msg1.obj = "这是一个从Worker Thread发送的普通信息";
            // 在Worker Thread 向UI Thread 发送一条消息
            mHandler.sendMessage(msg1);

            // 创建一个Message
            Message msg2 = new Message();
            msg2.what = 5;
            msg2.obj = "这是一个在指定的时间从Worker Thread发送的信息";
            // 在指定的时间Worker Thread 向UI Thread 发送一条消息
            mHandler.sendMessageAtTime(msg2,SystemClock.uptimeMillis()+1000);

            // 创建一个Message
            Message msg3 = new Message();
            msg3.what = 6;
            msg3.obj = "这是一个在指定的时间之后从Worker Thread发送的信息";
            // 在指定的时间之后Worker Thread 向UI Thread 发送一条消息
            mHandler.sendMessageDelayed(msg3,3000);

            // post方法可以让Runnable直接运行在UI Thread中
            mHandler.post(new Runnable() {
                @Override
                public void run() {
                    mTextView.setText("通过post方法，从Worker Thread回到了UI Thread");
                }
            });

            // postAtTime方法可以让Runnable在指定的时间直接运行在UI Thread中
            mHandler.postAtTime(new Runnable() {
                @Override
                public void run() {
                    mTextView.setText("通过postAtTime方法，从Worker Thread回到了UI Thread");
                }
            },SystemClock.uptimeMillis()+1000);

            // postDelayed方法可以让Runnable在指定的时间之后直接运行在UI Thread中
            mHandler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    mTextView.setText("通过postDelayed方法，从Worker Thread回到了UI Thread");
                }
            },5000);
        }
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler);

        mTextView = findViewById(R.id.tv_handler);

        //启动worker线程
        new WorkerThread().start();
    }
}
