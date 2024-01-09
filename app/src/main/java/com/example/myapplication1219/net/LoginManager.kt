package com.example.myapplication1219.net

import com.blankj.utilcode.util.SPUtils
import io.reactivex.schedulers.Schedulers
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
class LoginManager {
    companion object {
        fun getRetrofit(): Retrofit {
            val OkHttpClient = OkHttpClient.Builder()
                .writeTimeout(30, TimeUnit.SECONDS)
                .connectTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                .addInterceptor {
                    var token = SPUtils.getInstance().getString("sp_token")
                    var news = it.request().newBuilder()
                    val addHeader = news.addHeader("token", token)
                    it.proceed(addHeader.build())
                }
            val retrofit = Retrofit.Builder()
                .baseUrl("http://10.161.9.80:7012")
                .client(OkHttpClient.build())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
                .addConverterFactory(GsonConverterFactory.create())
            return retrofit.build()
        }
    }


}