package com.example.myapplication1219.pinglun

import androidx.lifecycle.MutableLiveData
import com.example.myapplication1219.base.BaseViewModel
import com.example.myapplication1219.pinglun.enity.Comment
import com.google.gson.Gson
import okhttp3.MediaType
import okhttp3.RequestBody

class PingViewModel:BaseViewModel() {
    var  getpinglunsuccess= MutableLiveData<Comment>()
    var  getpinglunfalure= MutableLiveData<String>()
    var  fapinglunsuccess= MutableLiveData<Comment>()
    var  fapinglunfalure= MutableLiveData<String>()
    val repo = PingRepo()
    fun getpinglun(id:Int){
        repo.getpinglun(id,getpinglunsuccess,getpinglunfalure)
    }
    fun fapinlun(msg:String,videoId:Int){
        val map = mutableMapOf<String,String>()
        map["msg"] = msg
        map["videoId"] = videoId.toString()
        val json = Gson().toJson(map)
        val create = RequestBody.create(MediaType.parse("application/json;charset=utf-8"), json)
        repo.fapinlun(create,fapinglunsuccess,fapinglunfalure)
    }
}