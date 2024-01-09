package com.example.myapplication1219.pinglun.enity

data class NewS(
    val code: Int,
    val `data`: Data,
    val msg: String
)

data class Data(
    val countId: Any,
    val current: Int,
    val maxLimit: Any,
    val optimizeCountSql: Boolean,
    val orders: List<Any>,
    val pages: Int,
    val records: List<Record>,
    val searchCount: Boolean,
    val size: Int,
    val total: Int
)

data class Record(
    val content: String,
    val createTime: String,
    val flag: Int,
    val id: Int,
    val imgurl: String,
    val looks: Int,
    val ntid: Int,
    val suid: Int,
    val title: String
)