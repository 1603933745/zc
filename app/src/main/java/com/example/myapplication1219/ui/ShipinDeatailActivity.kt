package com.example.myapplication1219.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication1219.R
import com.example.myapplication1219.base.BaseActivity
import com.example.myapplication1219.databinding.ActivityShipinDeatailBinding

class ShipinDeatailActivity : BaseActivity<ActivityShipinDeatailBinding>() {
    override fun initView() {
        val stringExtra = intent.getStringExtra("wb")
        val stringExtra1 = intent.getStringExtra("tit")
        if (stringExtra!=null ){
            dataBinding.shipinXiangqinTv.text = stringExtra1
            dataBinding.shipinXiangqinWv.loadUrl(stringExtra)
        }
    }

    override fun initData() {

    }

    override fun getLayoutId(): Int = R.layout.activity_shipin_deatail

}