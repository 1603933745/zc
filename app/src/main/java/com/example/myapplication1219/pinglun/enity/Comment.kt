package com.example.myapplication1219.pinglun.enity

data class Comment(
    val code: Int,
    val `data`: List<PingluntData>,
    val message: String
)

data class PingluntData(
    val childcount: Int,
    val createtime: String,
    val icon: String,
    val id: Int,
    val msg: String,
    val parentid: Int,
    val rootid: Int,
    val tousername: Any,
    val type: Int,
    val username: String
)