package com.example.design

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity : AppCompatActivity() {

    var myApplication: MyApplication? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        myApplication = MyApplication()
        myApplication?.auth?.userBucket?.name = "Welcome OnBoard! :)"

        onApplicationCreate(savedInstanceState)
    }

    abstract fun onApplicationCreate(savedInstanceState: Bundle?)

}