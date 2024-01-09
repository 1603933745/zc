package com.example.myapplication1219.home

import androidx.lifecycle.MutableLiveData
import com.example.myapplication1219.base.BaseViewModel
import com.example.myapplication1219.pinglun.enity.NewS
import com.example.myapplication1219.pinglun.enity.Type


class HomeViewModel:BaseViewModel() {
      val typesuccess:MutableLiveData<Type> = MutableLiveData()
      val  typefalure:MutableLiveData<String> = MutableLiveData()
    val   newsuccess:MutableLiveData<NewS> = MutableLiveData()
    val  newsfalure:MutableLiveData<String> = MutableLiveData()
    val repo = HomeRepo()
    fun getType(){
       repo.getType(typesuccess,typefalure)
    }
    fun getnews(type:Int,page:Int,size:Int){
        repo.getnews(type,page,size,newsuccess,newsfalure)
    }

}