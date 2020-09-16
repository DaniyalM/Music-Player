package com.example.design.login

import android.app.ActivityOptions
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.View
import com.example.design.BaseActivity
import com.example.design.R
import com.example.design.Utils
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_sign_up.*

class SignUp : BaseActivity(), View.OnClickListener {

    override fun onApplicationCreate(savedInstanceState: Bundle?) {
        Utils.hideStatusbar(window)
        setContentView(R.layout.activity_sign_up)
        signIn.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        val intent=Intent(this@SignUp,LoginScreen::class.java)
        val pairs = arrayOf(
            android.util.Pair<View, String>(logoImage, "logo_image"),
            android.util.Pair<View, String>(logoImageName, "logo_text"),
            android.util.Pair<View, String>(sloganName, "sln"),
            android.util.Pair<View, String>(userName, "logo_un"),
            android.util.Pair<View, String>(password, "logo_pass"),
            android.util.Pair<View, String>(go, "logo_go"),
            android.util.Pair<View, String>(signIn, "logo_signup")
        )
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            val activityOptions = ActivityOptions.makeSceneTransitionAnimation(
                this@SignUp,
                pairs[0],
                pairs[1],
                pairs[2],
                pairs[3],
                pairs[4],
                pairs[5],
                pairs[6]
            )
            startActivity(intent, activityOptions.toBundle())
        } else {
            startActivity(intent)
        }
    }
}