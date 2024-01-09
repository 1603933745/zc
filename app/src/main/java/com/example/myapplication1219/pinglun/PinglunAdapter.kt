package com.example.myapplication1219.pinglun

import com.bumptech.glide.Glide
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.example.myapplication1219.R
import com.example.myapplication1219.pinglun.enity.PingluntData
import org.w3c.dom.Comment

class PinglunAdapter(pinglist:ArrayList<PingluntData>)
    :BaseQuickAdapter<PingluntData,BaseViewHolder>(R.layout.pinglun_item,pinglist){
    override fun convert(helper: BaseViewHolder, item: PingluntData) {
          helper.setText(R.id.user,item.username)
        helper.setText(R.id.pinglun_tv,item.msg)
        helper.setText(R.id.time,item.createtime)
        Glide.with(context).load(item.icon).into(helper.getView(R.id.pinglun_im))
    }
}