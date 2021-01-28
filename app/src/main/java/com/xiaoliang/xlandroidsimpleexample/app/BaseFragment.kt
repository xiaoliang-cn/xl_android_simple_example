package com.xiaoliang.xlandroidsimpleexample.app

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

/*
*项目名: XLAndroidSimpleExample
*文件名: BaseFragment
*创建者: XiaoLiang
*创建时间:2021/1/28 9:59 PM
*描述: TODO
*/
abstract class BaseFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(setLayoutId(), container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }


    abstract fun setLayoutId(): Int
    abstract fun initView()
}