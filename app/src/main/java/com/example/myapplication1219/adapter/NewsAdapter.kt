package com.example.myapplication1219.adapter

import com.bumptech.glide.Glide
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.example.myapplication1219.R
import com.example.myapplication1219.pinglun.enity.Record

class NewsAdapter(newlist:ArrayList<Record>):
BaseQuickAdapter<Record,BaseViewHolder>(R.layout.news,newlist){
    override fun convert(helper: BaseViewHolder, item: Record) {
        Glide.with(context).load(item.imgurl).into(helper.getView(R.id.newsimage))
        helper.setText(R.id.newt1,item.title)

    }
}