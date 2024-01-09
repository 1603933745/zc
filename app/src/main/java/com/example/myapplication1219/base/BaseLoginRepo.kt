package com.example.myapplication1219.base

import com.example.myapplication1219.net.ApiService
import com.example.myapplication1219.net.LoginManager

abstract class BaseLoginRepo {
            fun getApiServicelogin():ApiService=LoginManager.getRetrofit().create(ApiService::class.java)
}