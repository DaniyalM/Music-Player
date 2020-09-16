package com.example.design

import android.os.Bundle
import android.util.Log
import android.widget.Toast

class PostLoginActivity : BaseAuthentication() {

    override fun postAuthCreate(savedInstanceState: Bundle?) {
        Toast.makeText(this, myApplication?.auth?.userBucket?.name!!, Toast.LENGTH_SHORT).show()
        Log.e(SplashScreen::class.java.simpleName, myApplication?.auth?.userBucket?.name!!)
    }
}