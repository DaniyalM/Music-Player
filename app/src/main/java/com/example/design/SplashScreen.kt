package com.example.design

import android.app.ActivityOptions
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import com.example.design.Utils.hideStatusbar
import kotlinx.android.synthetic.main.activity_main.*

class SplashScreen : BaseActivity() {
    private var topAnim: Animation? = null
    private var bottomAnim: Animation? = null

    companion object {
        private val SPLASH_TIMEOUT: Long = 5000
    }

    override fun onApplicationCreate(savedInstanceState: Bundle?) {
        hideStatusbar(window)
        setContentView(R.layout.activity_main)
        topAnim = AnimationUtils.loadAnimation(this, R.anim.top_animation)
        bottomAnim = AnimationUtils.loadAnimation(this, R.anim.bottom_animation)

        imageView.animation = topAnim
        textView.animation = bottomAnim

        textView2.apply {
            animation = bottomAnim
            text = "Hey Daniyal : ${myApplication?.auth?.userBucket?.name}"

        }
        Handler(Looper.getMainLooper()).postDelayed(
            {
                val intent = Intent(this, PostLoginActivity::class.java)
//                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                val pairs = arrayOf(
                    android.util.Pair<View, String>(imageView, "logo_image"),
                    android.util.Pair<View, String>(textView, "logo_text")
                )
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    val activityOptions = ActivityOptions.makeSceneTransitionAnimation(
                        this@SplashScreen,
                        pairs[0],
                        pairs[1]
                    )
                    startActivity(intent, activityOptions.toBundle())

                } else {
                    startActivity(intent)

                }
                finish()


            },
            SPLASH_TIMEOUT
        )


    }
}