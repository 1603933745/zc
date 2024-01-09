package com.example.myapplication1219.Video

import androidx.lifecycle.MutableLiveData
import com.example.myapplication1219.base.BaseRepo
import com.example.myapplication1219.pinglun.enity.Shipin
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable

class VideoRepo:BaseRepo() {
    fun getshipin(order: Int,page: Int, size: Int, success: MutableLiveData<Shipin>, falure: MutableLiveData<String>){
        getApiService().getvideo( order, page, size).observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : Observer<Shipin> {
                override fun onSubscribe(d: Disposable) {

                }

                override fun onError(e: Throwable) {
                    falure.value=e.message
                }

                override fun onComplete() {

                }

                override fun onNext(t: Shipin) {
                    success.value=t
                }

            })
    }
}