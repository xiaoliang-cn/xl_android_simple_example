package com.xiaoliang.xlandroidsimpleexample.paging

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.xiaoliang.xlandroidsimpleexample.R

/*
*项目名: XLAndroidSimpleExample
*文件名: RepoViewHolder
*创建者: XiaoLiang
*创建时间:2021/1/19 9:32 AM
*描述: TODO
*/
class AnimalViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val name = view.findViewById<TextView>(R.id.aniaml_name)
    val age = view.findViewById<TextView>(R.id.animal_age)
    val content = view.findViewById<TextView>(R.id.animal_content)
    val image = view.findViewById<ImageView>(R.id.animal_image)

}
