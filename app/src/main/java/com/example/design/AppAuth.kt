package com.example.design

import android.content.Context

class AppAuth(private val context: Context) {
    val  userBucket:UserBucket

    init {
        userBucket= UserBucket()
    }
}