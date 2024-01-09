package com.example.myapplication1219.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.blankj.utilcode.util.SPUtils
import com.blankj.utilcode.util.ToastUtils
import com.example.myapplication1219.R
import com.example.myapplication1219.base.BaseActivity
import com.example.myapplication1219.databinding.ActivityLoginBinding
import com.example.myapplication1219.ui.DetailMainActivity
import com.example.myapplication1219.ui.MainActivity

class LoginActivity : BaseActivity<ActivityLoginBinding>() {
    lateinit var viewModel: LoginVIewViewModel
    override fun initView() {
        viewModel = ViewModelProvider(this)[LoginVIewViewModel::class.java]
        viewModel.loginsuccess.observe(this) {
            if (it.code == 200) {
                ToastUtils.showLong("${it.message}")
                SPUtils.getInstance().put("sp_token", it.data.token)
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }else{
                ToastUtils.showLong("登录失败")
            }
        }

    }

    override fun initData() {

        dataBinding.login.setOnClickListener {
            viewModel.login(
                dataBinding.zhanghao.text.toString(),
                dataBinding.mima.text.toString()
            )
        }


    }

    override fun getLayoutId(): Int {
        return R.layout.activity_login
    }

}