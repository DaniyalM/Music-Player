package com.example.design.login

import android.app.ActivityOptions
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.WindowInsets
import android.view.WindowManager
import android.widget.Button
import android.widget.Toast
import com.example.design.BaseActivity
import com.example.design.R
import com.example.design.Utils
import com.example.design.Utils.hideStatusbar
import kotlinx.android.synthetic.main.activity_login_screen.*
import kotlinx.android.synthetic.main.activity_login_screen.go
import kotlinx.android.synthetic.main.activity_login_screen.logoImage
import kotlinx.android.synthetic.main.activity_login_screen.logoImageName
import kotlinx.android.synthetic.main.activity_login_screen.sloganName
import kotlinx.android.synthetic.main.activity_login_screen.userName
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_sign_up.*

class LoginScreen : BaseActivity(), View.OnClickListener {

    override fun onApplicationCreate(savedInstanceState: Bundle?) {
        hideStatusbar(window)
        setContentView(R.layout.activity_login_screen)

        signUp.setOnClickListener(this)
        Toast.makeText(this, "Hello Its Login Here", Toast.LENGTH_SHORT).show()
    }

    override fun onClick(v: View?) {
        val intent = Intent(this@LoginScreen,SignUp::class.java)
        val pairs = arrayOf(
            android.util.Pair<View, String>(logoImage, "logo_image"),
            android.util.Pair<View, String>(logoImageName, "logo_text"),
            android.util.Pair<View, String>(sloganName, "sln"),
            android.util.Pair<View, String>(userName, "logo_un"),
            android.util.Pair<View, String>(passWord, "logo_pass"),
            android.util.Pair<View, String>(go, "logo_go"),
            android.util.Pair<View, String>(signUp, "logo_signup")
        )
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            val activityOptions = ActivityOptions.makeSceneTransitionAnimation(
                this@LoginScreen,
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