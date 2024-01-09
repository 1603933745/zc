package com.example.myapplication1219.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

abstract class BaseActivity<VDB:ViewDataBinding>:AppCompatActivity() {
     lateinit var dataBinding: VDB
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
           dataBinding=DataBindingUtil.setContentView(this,getLayoutId())
        initData()
        initView()
    }

    abstract fun initView()

    abstract fun initData()

    abstract fun getLayoutId(): Int
}