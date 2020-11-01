package com.example.design.login

import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

object LoginUtils {
    fun lookUpForUserName(editText: TextInputLayout): Boolean {
        val userName = editText.editText?.text.toString()
        if (userName.isEmpty()){
            editText.error="Username is Required."
            return false
        }
        else {
            editText.error = null
            editText.isErrorEnabled = false
            return true
        }
    }

    fun passWordValidation(editText: TextInputLayout): Boolean {
        val passWord = editText.editText?.text.toString()
        if (passWord.isEmpty()){
            editText.error="Password is Required."
            return false
        }
       else{
            editText.error = null
            editText.isErrorEnabled = false
            return true
        }
    }

}