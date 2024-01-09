package com.example.myapplication1219.login

import androidx.lifecycle.MutableLiveData
import com.example.myapplication1219.base.BaseViewModel
import com.example.myapplication1219.pinglun.enity.Login
import com.google.gson.Gson
import okhttp3.MediaType
import okhttp3.RequestBody

class LoginVIewViewModel : BaseViewModel() {
    var loginsuccess = MutableLiveData<Login>()
    var loginfalure = MutableLiveData<String>()
    val repo = LoginRepo()

    fun login(username: String, password: String) {
        val map = mutableMapOf<String, String>()
        map["username"] = username
        map["password"] = password
        val json = Gson().toJson(map)
        val create = RequestBody.create(MediaType.parse("application/json;charset=utf-8"), json)
        repo.Login(create, loginsuccess, loginfalure)
    }


}