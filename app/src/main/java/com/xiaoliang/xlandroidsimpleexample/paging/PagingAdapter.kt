package com.xiaoliang.xlandroidsimpleexample.paging

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import com.bumptech.glide.Glide
import com.xiaoliang.xlandroidsimpleexample.R
import com.xiaoliang.xlandroidsimpleexample.base.mContext
import com.xiaoliang.xlandroidsimpleexample.room.Animal


/*
*项目名: XLAndroidSimpleExample
*文件名: PagingAdapter
*创建者: XiaoLiang
*创建时间:2021/1/19 10:25 AM
*描述: TODO
*/
//
val DIFF_CALLBACK =
    object : DiffUtil.ItemCallback<Animal>() {
        override fun areItemsTheSame(oldConcert: Animal, newConcert: Animal): Boolean {
            return oldConcert.name.equals(newConcert.name)
        }
        override fun areContentsTheSame(
            oldConcert: Animal,
            newConcert: Animal
        ): Boolean {
            return oldConcert == newConcert
        }
    }

class PagingAdapter : PagedListAdapter<Animal, AnimalViewHolder>(DIFF_CALLBACK) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimalViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.aniaml_item, parent, false)
        return AnimalViewHolder(view)
    }
    override fun onBindViewHolder(holder: AnimalViewHolder, position: Int) {
        Log.d("PagingAdapter====", currentList?.size.toString())
        Log.d("PagingAdapter", getItem(position).toString())
        getItem(position)?.let { animal ->
            holder.name.text = animal.name
            holder.age.text = animal.age.toString()
            holder.content.text = animal.content
            Glide.with(mContext).load(animal.image).into(holder.image)
        }

    }

}

