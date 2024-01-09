package com.example.myapplication1219.ui

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.myapplication1219.R
import com.example.myapplication1219.Video.Video_ViewModel
import com.example.myapplication1219.adapter.ShipinAdapter
import com.example.myapplication1219.base.BaseFragment
import com.example.myapplication1219.databinding.FragmentBlank2Binding
import com.example.myapplication1219.pinglun.enity.ShipinData
import com.example.myapplication1219.pinglun.enity.ShipinRecord
import com.example.myapplication1219.home.HomeViewModel


class BlankFragment2 :BaseFragment<FragmentBlank2Binding>() {
    lateinit var viewModel: Video_ViewModel
     var listone = ArrayList<ShipinData> ()
     var listtwo = ArrayList<ShipinRecord> ()
    lateinit var shipindapter:ShipinAdapter
    override fun initView() {
        viewModel= ViewModelProvider(this)[Video_ViewModel::class.java]
        viewModel.getshipin(1,1,10)
        viewModel.Shipinsuccess.observe(this){
            listone.clear()
            listone.add(it.data)
            var shipindata = listone[0].records
            if (shipindata!=null){
                listtwo.clear()
                listtwo.addAll(shipindata)
                shipindapter.notifyDataSetChanged()
            }

        }
    }

    override fun initData() {
        dataBinding.videoRv.layoutManager = GridLayoutManager(context,1)
        shipindapter  = ShipinAdapter(listtwo)
        dataBinding.videoRv.adapter = shipindapter

        shipindapter.setOnItemClickListener { adapter, view, position ->
            val intent = Intent(context,ShipinDeatailActivity::class.java)
            intent.putExtra("wb",listtwo[position].videourl)
            intent.putExtra("tit",listtwo[position].info)
            startActivity(intent)
        }
    }

    override fun getLayoutId(): Int {
       return R.layout.fragment_blank2
    }

}