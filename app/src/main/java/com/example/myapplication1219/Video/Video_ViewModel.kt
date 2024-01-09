package com.example.myapplication1219.Video

import androidx.lifecycle.MutableLiveData
import com.example.myapplication1219.base.BaseViewModel
import com.example.myapplication1219.pinglun.enity.Shipin

class Video_ViewModel:BaseViewModel() {
    val Shipinsuccess: MutableLiveData<Shipin> = MutableLiveData()
    val  Shiupinfalure: MutableLiveData<String> = MutableLiveData()
    val repo = VideoRepo()
    fun getshipin( order: Int,
                 page: Int,
                 size: Int){
        repo.getshipin(order,page,size,Shipinsuccess,Shiupinfalure)
    }
}