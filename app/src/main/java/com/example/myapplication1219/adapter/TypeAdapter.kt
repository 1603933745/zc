package com.example.myapplication1219.adapter

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.example.myapplication1219.R
import com.example.myapplication1219.pinglun.enity.TypeData

class TypeAdapter(typelist:ArrayList<TypeData>):
    BaseQuickAdapter<TypeData,BaseViewHolder>(R.layout.type,typelist) {
    override fun convert(helper: BaseViewHolder, item: TypeData) {
        helper.setText(R.id.typetv,item.name)
    }
}