package com.xiaoliang.xlandroidsimpleexample.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.xiaoliang.xlandroidsimpleexample.R

/*
*项目名: XLAndroidSimpleExample
*文件名: SimpleAdapter
*创建者: XiaoLiang
*创建时间:2021/1/16 7:36 PM
*描述: TODO
*/
class SimpleAdapter(val mData: MutableList<String>) :
    RecyclerView.Adapter<SimpleAdapter.SimpleViewHolder>() {
    class SimpleViewHolder(mView: View) : RecyclerView.ViewHolder(mView) {
        val textView = mView.findViewById<TextView>(R.id.item_nav_textView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SimpleViewHolder {
        val lView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_textview, parent, false)
        return SimpleViewHolder(lView)
    }

    override fun getItemCount() = mData.size
    override fun onBindViewHolder(holder: SimpleViewHolder, position: Int) {
        holder.textView.text = mData[position]
    }

}