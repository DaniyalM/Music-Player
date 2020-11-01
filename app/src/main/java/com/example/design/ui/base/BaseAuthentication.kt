package com.example.design.ui.base

import android.content.Intent
import android.os.Bundle
import com.example.design.login.LoginScreen

abstract class BaseAuthentication : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (!spotifyApplication?.auth?.userBucket?.isLoggedIn!!) {
            startActivity(Intent(this, LoginScreen::class.java))
            finish()
        }
        postAuthCreate(savedInstanceState)
    }

    protected abstract fun postAuthCreate(savedInstanceState: Bundle?)

}