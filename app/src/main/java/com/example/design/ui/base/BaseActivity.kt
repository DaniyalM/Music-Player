package com.example.design.ui.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.design.SpotifyApplication

abstract class BaseActivity : AppCompatActivity() {

   protected var spotifyApplication: SpotifyApplication? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        spotifyApplication = application as SpotifyApplication
        spotifyApplication?.auth?.userBucket?.name = "Welcome OnBoard! :)"

    }


}