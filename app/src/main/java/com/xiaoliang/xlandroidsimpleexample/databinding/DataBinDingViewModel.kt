package com.xiaoliang.xlandroidsimpleexample.databinding

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.util.*

/*
*项目名: XLAndroidSimpleExample
*文件名: DataBinDingVIewModel
*创建者: XiaoLiang
*创建时间:2021/1/16 8:51 PM
*描述: TODO
*/
class DataBinDingViewModel : ViewModel() {
    private val _name = MutableLiveData("xiao")
    private val _lastName = MutableLiveData("liang")
//    private val _likes = MutableLiveData(0)

    val name: LiveData<String> = _name
    val lastName: LiveData<String> = _lastName
//    val likes: LiveData<Int> = _likes


    fun onLike() {
        _name.value = UUID.randomUUID().toString()
    }

}