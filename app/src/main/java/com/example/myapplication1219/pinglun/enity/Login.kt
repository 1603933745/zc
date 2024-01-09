package com.example.myapplication1219.pinglun.enity

data class Login(
    val code: Int,
    val `data`: LoginData,
    val message: String
)

data class LoginData(
    val address: String,
    val admin: Boolean,
    val birth: Any,
    val coinCount: Int,
    val email: Any,
    val icon: String,
    val id: Int,
    val nickname: String,
    val password: String,
    val publicName: Any,
    val sex: Any,
    val token: String,
    val type: Int,
    val username: String
)