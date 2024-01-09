package com.example.myapplication1219.base

import com.example.myapplication1219.net.ApiService
import com.example.myapplication1219.net.RetrofitManager

abstract class BaseRepo {
    fun getApiService():ApiService=RetrofitManager.getRetrofit().create(ApiService::class.java)
}