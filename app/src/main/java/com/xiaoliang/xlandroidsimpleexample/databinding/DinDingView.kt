package com.xiaoliang.xlandroidsimpleexample.databinding

import android.widget.ProgressBar
import android.widget.TextView
import androidx.databinding.BindingAdapter


/*
*项目名: XLAndroidSimpleExample
*文件名: DinDingView
*创建者: XiaoLiang
*创建时间:2021/1/16 8:15 PM
*描述: TODO
*/

//单个参数绑定
@BindingAdapter("android:text123")
fun setText(view: TextView, text: CharSequence?) {
    // Some checks removed for clarity
    view.text = text
}

//多个参数绑定
@BindingAdapter(value = ["app:progressScaled", "android:max"], requireAll = true)
fun setProgress(progressBar: ProgressBar, likes: Int, max: Int) {
    progressBar.progress = (likes * max / 5).coerceAtMost(max)
}
