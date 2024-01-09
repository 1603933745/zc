package com.example.myapplication1219.home

import androidx.lifecycle.MutableLiveData
import com.example.myapplication1219.base.BaseRepo
import com.example.myapplication1219.pinglun.enity.NewS
import com.example.myapplication1219.pinglun.enity.Type
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable


class HomeRepo:BaseRepo() {

        fun  getnews(type:Int, page:Int, size:Int, success:MutableLiveData<NewS>, falure:MutableLiveData<String>){
                getApiService().getnews(type, page, size).observeOn(AndroidSchedulers.mainThread())
                        .subscribe(object :Observer<NewS>{
                                override fun onSubscribe(d: Disposable) {

                                }

                                override fun onError(e: Throwable) {
                             falure.value=e.message
                                }

                                override fun onComplete() {

                                }

                                override fun onNext(t: NewS) {
                               success.value=t
                                }

                        })
        }
        fun  getType(success:MutableLiveData<Type>, falure:MutableLiveData<String>){
            getApiService().gettype().observeOn(AndroidSchedulers.mainThread())
                    .subscribe(object :Observer<Type>{
                            override fun onSubscribe(d: Disposable) {

                            }

                            override fun onError(e: Throwable) {
                                    falure.value=e.message
                            }

                            override fun onComplete() {

                            }

                            override fun onNext(t: Type) {
                                   success.value=t
                            }

                    })
        }
}