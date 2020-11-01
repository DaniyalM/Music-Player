package com.example.design.ui

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.design.ui.base.BaseAuthentication

class PostLoginActivity : BaseAuthentication() {

    override fun postAuthCreate(savedInstanceState: Bundle?) {
        Toast.makeText(this, spotifyApplication?.auth?.userBucket?.name!!, Toast.LENGTH_SHORT).show()
        Log.e(SplashScreen::class.java.simpleName, spotifyApplication?.auth?.userBucket?.name!!)
    }
}