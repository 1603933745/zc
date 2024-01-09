package com.example.myapplication1219.ui

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication1219.R
import com.example.myapplication1219.adapter.NewsAdapter
import com.example.myapplication1219.adapter.TypeAdapter
import com.example.myapplication1219.base.BaseFragment
import com.example.myapplication1219.databinding.FragmentBlankBinding
import com.example.myapplication1219.pinglun.enity.Record
import com.example.myapplication1219.pinglun.enity.TypeData
import com.example.myapplication1219.home.HomeViewModel
import com.scwang.smart.refresh.layout.api.RefreshLayout
import com.scwang.smart.refresh.layout.listener.OnRefreshLoadMoreListener


class BlankFragment : BaseFragment<FragmentBlankBinding>() {
     lateinit var viewModel: HomeViewModel
     lateinit var  typeadapter:TypeAdapter
     var typelist= ArrayList<TypeData>()
     var newlist=ArrayList<Record>()
    var sounewlist=ArrayList<Record>()
    lateinit var  newadapter:NewsAdapter
    var type=0
    var page=1

    override fun initView() {

        viewModel=ViewModelProvider(this)[HomeViewModel::class.java]
        viewModel.getType()
        viewModel.typesuccess.observe(this){
            typelist.clear()
            typelist.addAll(it.data)
            typeadapter.notifyDataSetChanged()
        }
        viewModel.getnews(type,page,10)
        viewModel.newsuccess.observe(this){
            newlist.clear()
            newlist.addAll(it.data.records)
            newadapter.notifyDataSetChanged()
        }
        newadapter.setOnItemClickListener { adapter, view, position ->
            val intent = Intent(context, DetailMainActivity::class.java)
            intent.putExtra("id",newlist[position].id)
            intent.putExtra("image",newlist[position].imgurl)
            intent.putExtra("content",newlist[position].content)
            startActivity(intent)
        }
    }

    override fun initData() {
         dataBinding.typerec.layoutManager=LinearLayoutManager(context,RecyclerView.HORIZONTAL,false)
        typeadapter=TypeAdapter(typelist)
        dataBinding.typerec.adapter=typeadapter

        dataBinding.newsrec.layoutManager=GridLayoutManager(context,1)
        newadapter= NewsAdapter(newlist)
        dataBinding.newsrec.adapter=newadapter
        typeadapter.setOnItemClickListener { adapter, view, position ->
            newlist.clear()
            type=typelist[position].id
            viewModel.getnews(type,page,10)
        }
        dataBinding.reflash.setOnRefreshLoadMoreListener(object :
            OnRefreshLoadMoreListener {
            override fun onRefresh(refreshLayout: RefreshLayout) {
                if (refreshLayout.isLoading){
                    refreshLayout.finishLoadMore()
                }
                newlist.clear()
                page = 1
                viewModel.getnews(type,page,10)
            }

            override fun onLoadMore(refreshLayout: RefreshLayout) {
                if (refreshLayout.isRefreshing){
                    refreshLayout.finishRefresh()
                }
                page+=1
                viewModel.getnews(type,page,10)
            }

        })


        dataBinding.sousuoButton.setOnClickListener {
            val toString = dataBinding.sousuoText.text.toString()
            sounewlist.clear()
            newlist.forEach {
                if (it.title.contains(toString)){
                    sounewlist.add(it)
                }
            }
            newadapter= NewsAdapter(sounewlist)
            dataBinding.newsrec.adapter=newadapter
        }
    }

    override fun getLayoutId(): Int {
       return R.layout.fragment_blank
    }

}