package com.example.design.login

import com.google.android.material.textfield.TextInputLayout

object RegistrationUtils {
    fun validateFullName(editText: TextInputLayout): Boolean {
        val fullName = editText.editText?.text.toString()
        if (fullName.isEmpty()) {
            editText.error = "Field cannot be empty"
            return false
        } else {
            editText.error = null
            editText.isErrorEnabled = false
            return true
        }
    }

    fun validateUserName(editText: TextInputLayout): Boolean {
        val userName = editText.editText?.text.toString()
        val noWhiteSpaceRegix = "\\A\\w{4,20}\\z"
        if (userName.isEmpty()) {
            editText.error = "Field Cannot be Empty"
            return false
        } else if (userName.length >= 15) {
            editText.error = "Username too Long.."
            return false

        }
        else if (!userName.matches(noWhiteSpaceRegix.toRegex())) {
            editText.error = "White spaces are not allowed.."
            return false }
        else {
            editText.error = null
            editText.isErrorEnabled = false

            return true
        }
    }

    fun validateEmail(editText: TextInputLayout): Boolean {
        val email = editText.editText?.text.toString()
        val emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"

        if (email.isEmpty()) {
            editText.error = "Field Cannot be Empty"
            return false
        } else if (!email.matches(emailPattern.toRegex())) {
            editText.error = "Invalid Email Address"
            return false

        } else {
            editText.error = null
            editText.isErrorEnabled = false

            return true
        }
    }

    fun validatePassword(editText: TextInputLayout): Boolean {
        val passWord = editText.editText?.text.toString()
        val passwordPattern = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{4,}$"

        if (passWord.isEmpty()) {
            editText.error = "Field Cannot be Empty"
            return false
        } else if (!passWord.matches(passwordPattern.toRegex())) {
            editText.error = "Password Is too Weak"
            return false
        } else {
            editText.error = null
            editText.isErrorEnabled = false

            return true
        }
    }

    fun validatePhone(editText: TextInputLayout): Boolean {
        val phone = editText.editText?.text.toString()
        if (phone.isEmpty()) {
            editText.error = "Field Cannot be Empty"
            return false
        } else {
            editText.error = null
            editText.isErrorEnabled = false

            return true
        }
    }
}