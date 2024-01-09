package com.example.myapplication1219.pinglun

import androidx.lifecycle.MutableLiveData
import com.example.myapplication1219.base.BaseLoginRepo
import com.example.myapplication1219.pinglun.enity.Comment
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import okhttp3.RequestBody

class PingRepo :BaseLoginRepo(){
    fun getpinglun(id:Int, success: MutableLiveData<Comment>, falure: MutableLiveData<String>){
        getApiServicelogin().getpinglun(id).observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : Observer<Comment> {
                override fun onSubscribe(d: Disposable) {

                }

                override fun onError(e: Throwable) {
                    falure.value=e.message
                }

                override fun onComplete() {

                }

                override fun onNext(t: Comment) {
                    success.value=t
                }

            })
    }
    fun fapinlun(body: RequestBody, success: MutableLiveData<Comment>, falure: MutableLiveData<String>){
        getApiServicelogin().fapinglun(body).observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : Observer<Comment> {
                override fun onSubscribe(d: Disposable) {

                }

                override fun onError(e: Throwable) {
                    falure.value=e.message
                }

                override fun onComplete() {

                }

                override fun onNext(t: Comment) {
                    success.value=t
                }

            })
    }
}