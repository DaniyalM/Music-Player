package com.example.design

import android.app.Application
import com.example.design.ui.base.AppAuth
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class SpotifyApplication : Application() {

   lateinit var auth: AppAuth

    override fun onCreate() {
        super.onCreate()
        auth = AppAuth(this)
    }

}