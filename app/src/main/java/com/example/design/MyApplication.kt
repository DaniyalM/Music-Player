package com.example.design

import android.app.Application

class MyApplication : Application() {

   var auth: AppAuth

    init {
        auth = AppAuth(this)
    }


}