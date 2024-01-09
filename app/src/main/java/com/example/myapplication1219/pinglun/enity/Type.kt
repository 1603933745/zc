package com.example.myapplication1219.pinglun.enity

data class Type(
    val code: Int,
    val `data`: List<TypeData>,
    val msg: String
)

data class TypeData(
    val createTime: String,
    val id: Int,
    val info: String,
    val name: String
)