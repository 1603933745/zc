package com.example.myapplication1219.ui

import android.content.Intent
import androidx.recyclerview.widget.GridLayoutManager
import com.blankj.utilcode.util.ToastUtils
import com.bumptech.glide.Glide
import com.example.myapplication1219.R
import com.example.myapplication1219.base.BaseActivity
import com.example.myapplication1219.databinding.ActivityDetailMainBinding
import com.example.myapplication1219.pinglun.enity.PingluntData
import com.example.myapplication1219.pinglun.PingViewModel
import com.example.myapplication1219.pinglun.PinglunAdapter


class DetailMainActivity : BaseActivity<ActivityDetailMainBinding>() {

    var pinglunlist=ArrayList<PingluntData>()
    lateinit var pinglunAdapter:PinglunAdapter
    var viewModel=PingViewModel()

    var id:Int = 0
    override fun initView() {
        id = intent.getIntExtra("id", 0)
        val content = intent.getStringExtra("content").toString()
        val image = intent.getStringExtra("image").toString()
        Glide.with(this).load(image).into(dataBinding.detailimage)
        dataBinding.detailcontextt2.text=content
        viewModel.getpinglun(id)
        viewModel.getpinglunsuccess.observe(this){
           pinglunlist.clear()
          pinglunlist.addAll(it.data)
            pinglunAdapter.notifyDataSetChanged()
        }

        viewModel.fapinglunsuccess.observe(this){
            ToastUtils.showLong("发送成功")
            viewModel.getpinglun(id)
        }

    }

    override fun initData() {
        dataBinding.pinglunrec.layoutManager=GridLayoutManager(this,1)
        pinglunAdapter=PinglunAdapter(pinglunlist)
        dataBinding.pinglunrec.adapter=pinglunAdapter

        dataBinding.send.setOnClickListener {
            viewModel.fapinlun(
                dataBinding.edit.text.toString(),
                id
            )
        }

    }

    override fun getLayoutId(): Int {
      return R.layout.activity_detail_main
    }

}