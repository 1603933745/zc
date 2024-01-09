package com.example.myapplication1219.login

import androidx.lifecycle.MutableLiveData
import com.example.myapplication1219.base.BaseLoginRepo
import com.example.myapplication1219.pinglun.enity.Login
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import okhttp3.RequestBody


class LoginRepo : BaseLoginRepo() {
    fun Login(body: RequestBody, success: MutableLiveData<Login>, falure: MutableLiveData<String>) {
        getApiServicelogin().login(body).observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : Observer<Login> {
                override fun onSubscribe(d: Disposable) {

                }

                override fun onError(e: Throwable) {
                    falure.value = e.message
                }

                override fun onComplete() {

                }

                override fun onNext(t: Login) {
                    success.value = t
                }

            })
    }
}