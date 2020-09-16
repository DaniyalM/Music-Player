package com.example.design

import android.content.Intent
import android.os.Bundle
import com.example.design.login.LoginScreen

abstract class BaseAuthentication : BaseActivity() {

    override fun onApplicationCreate(savedInstanceState: Bundle?) {
        myApplication?.auth?.userBucket?.isLoggedIn = false
        if (!myApplication?.auth?.userBucket?.isLoggedIn!!) {
            startActivity(Intent(this, LoginScreen::class.java))
            finish()
        }
        postAuthCreate(savedInstanceState)
    }

    abstract fun postAuthCreate(savedInstanceState: Bundle?)

}