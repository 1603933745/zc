package com.example.myapplication1219.adapter

import com.bumptech.glide.Glide
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.example.myapplication1219.R
import com.example.myapplication1219.pinglun.enity.ShipinRecord
class ShipinAdapter (list:ArrayList<ShipinRecord>):
    BaseQuickAdapter<ShipinRecord, BaseViewHolder>(R.layout.item_video,list){
    override fun convert(helper: BaseViewHolder, item: ShipinRecord) {
        helper.setText(R.id.video_tv,item.title)
        Glide.with(context).load(item.imgurl).into(helper.getView(R.id.video_iv))
    }
}