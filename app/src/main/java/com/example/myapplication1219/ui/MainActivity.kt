package com.example.myapplication1219.ui

import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.myapplication1219.R
import com.example.myapplication1219.base.BaseActivity
import com.example.myapplication1219.databinding.ActivityMainBinding

class MainActivity : BaseActivity<ActivityMainBinding>() {
    override fun initView() {

    }

    override fun initData() {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        val navController = navHostFragment.navController
        dataBinding.bottom.setupWithNavController(navController)
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }

}