package com.example.design.login

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.design.ui.base.BaseActivity
import com.example.design.R
import com.example.design.Utils.hideStatusbar
import com.example.design.login.RegistrationUtils.validateEmail
import com.example.design.login.RegistrationUtils.validateFullName
import com.example.design.login.RegistrationUtils.validatePassword
import com.example.design.login.RegistrationUtils.validatePhone
import com.example.design.login.RegistrationUtils.validateUserName
import kotlinx.android.synthetic.main.activity_sign_up.*

class SignUp : BaseActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        hideStatusbar(window)
        setContentView(R.layout.activity_sign_up)
        signIn.setOnClickListener(this)
        go.setOnClickListener(this)
    }

    override fun onClick(v: View?) {

        when (v?.id) {
            R.id.signIn -> {
                startActivity(Intent(this@SignUp, LoginScreen::class.java))
                finish()
            }
            R.id.go -> initiateValidation()
        }

    }

    private fun initiateValidation() {
        if (!validateFullName(name) || !validateUserName(userName) || !validateEmail(email) || !validatePhone(phone) || !validatePassword(password)) {
            return
        } else {
            Toast.makeText(this, "Successfully Registered now try to Login.",
                Toast.LENGTH_SHORT)
                .show()
        }


    }


}