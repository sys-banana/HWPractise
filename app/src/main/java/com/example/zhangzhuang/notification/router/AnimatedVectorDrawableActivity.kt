//package com.example.zhangzhuang.notification.router
//
//import android.graphics.drawable.Drawable
//import android.os.Build
//import android.os.Bundle
//import android.support.annotation.RequiresApi
//import android.support.graphics.drawable.Animatable2Compat
//import android.support.graphics.drawable.AnimatedVectorDrawableCompat
//import android.support.v7.app.AppCompatActivity
//import android.util.Log
//import android.widget.ImageView
//import com.example.zhangzhuang.notification.R
//
//class AnimatedVectorDrawableActivity : AppCompatActivity() {
//    private lateinit var animatable2Compat: Animatable2Compat
//
//    @RequiresApi(Build.VERSION_CODES.M)
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.animate)
//
//        var image = findViewById<ImageView>(R.id.image)
//        var animatedVectorDrawableCompat = AnimatedVectorDrawableCompat.create(this, R.drawable.abc_ab_share_pack_mtrl_alpha)
//        image.setImageDrawable(animatedVectorDrawableCompat)
//        animatable2Compat = image.drawable as Animatable2Compat
//        animatable2Compat.registerAnimationCallback(object : Animatable2Compat.AnimationCallback() {
//            override fun onAnimationStart(drawable: Drawable?) {
//                Log.e("gpj", "onAnimationStart")
//            }
//            override fun onAnimationEnd(drawable: Drawable?) {
//                Log.e("gpj", "onAnimationEnd")
//            }
//        })
//        animatable2Compat.start()
//    }
//
//    override fun onDestroy() {
//        super.onDestroy()
//        animatable2Compat.stop()
//    }
//}