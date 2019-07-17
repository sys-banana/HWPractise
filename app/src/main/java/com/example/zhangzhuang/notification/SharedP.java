package com.example.zhangzhuang.notification;

        import android.content.Context;
        import android.content.SharedPreferences;
        import android.os.Bundle;
        import android.os.Environment;
        import android.support.annotation.Nullable;
        import android.support.v7.app.AppCompatActivity;
        import android.util.Log;

        import java.io.File;

public class SharedP extends AppCompatActivity {
    private Context context;

    private SharedPreferences sharedPreference;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


//        sharedPreference = getPreferences(Context.MODE_PRIVATE);
//        SharedPreferences.Editor editor = sharedPreference.edit();
//        editor.putInt(getString(R.string.app_name),100);
//        editor.commit();
//
//
////        int defaultValue = getResources().getInteger(R.integer.high_score);
//        long highScore = sharedPreference.getInt(getString(R.string.app_name),100);
//
//
////        int defaultValue = getResources().getString(R.string.high_score);
////        long highScore = sharedPreference.getInt(getString(R.string.high_score),defaultValue);
//
        File a = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES),"aaa");
        Log.e("----------->",a.toString());

        String state = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(state)){
            Log.e("----------->","存在");
        }else {
            Log.e("----------->","不存在");
        }



    }
}
