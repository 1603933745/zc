package com.example.myapplication1219.pinglun.enity

data class Shipin(
    val code: Int,
    val `data`: ShipinData,
    val msg: String
)

data class ShipinData(
    val countId: Any,
    val current: Int,
    val maxLimit: Any,
    val optimizeCountSql: Boolean,
    val orders: List<Any>,
    val pages: Int,
    val records: List<ShipinRecord>,
    val searchCount: Boolean,
    val size: Int,
    val total: Int
)

data class ShipinRecord(
    val createTime: String,
    val flag: Int,
    val id: Int,
    val imgurl: String,
    val info: String,
    val looks: Int,
    val suid: Int,
    val title: String,
    val type: Int,
    val videourl: String
)