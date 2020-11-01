package com.example.design.login

import android.app.ActivityOptions
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.View
import com.example.design.ui.base.BaseActivity
import com.example.design.R
import com.example.design.Utils.hideStatusbar
import com.example.design.login.LoginUtils.lookUpForUserName
import com.example.design.login.LoginUtils.passWordValidation
import com.example.design.ui.HomeActivity
import com.google.android.material.textfield.TextInputLayout
import kotlinx.android.synthetic.main.activity_login_screen.*

class LoginScreen : BaseActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        hideStatusbar(window)
        setContentView(R.layout.activity_login_screen)

        signUp.setOnClickListener(this)
        go.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.signUp -> {
                val intent = Intent(this@LoginScreen, SignUp::class.java)
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
            R.id.go -> initiateLogin(userName, passWord)
        }

    }

    private fun initiateLogin(userName: TextInputLayout, passWord: TextInputLayout) {

        if (!lookUpForUserName(userName) || !passWordValidation(passWord)) {
            return
        } else {

            spotifyApplication?.auth?.userBucket?.isLoggedIn = true

            startActivity(Intent(this, HomeActivity::class.java))
            finish()
        }
    }
}