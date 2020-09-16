package com.example.design

class UserBucket {
    var id: Int = 0
        get() = field
        set(value) {
            field = value
        }
    var name: String = ""
        get
        set(value) {
            field = value
        }
    var email: String = ""
        get
        set(value) {
            field = value
        }
    var password: String = ""
        get
        set(value) {
            field = value
        }
    var isLoggedIn: Boolean = false
        get
        set(value) {
            field = value
        }

}