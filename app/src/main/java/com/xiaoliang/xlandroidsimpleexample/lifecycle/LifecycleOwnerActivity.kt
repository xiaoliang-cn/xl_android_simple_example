package com.xiaoliang.xlandroidsimpleexample.lifecycle

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ProcessLifecycleOwner
import com.xiaoliang.xlandroidsimpleexample.R
import com.xiaoliang.xlandroidsimpleexample.databinding.ActivityLifecycleOwnerBinding
import org.koin.android.ext.android.inject

class LifecycleOwnerActivity : AppCompatActivity() {

    val lifecycleOwnerTest: LifecycleOwnerTest by inject()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val DataBinDingLView: ActivityLifecycleOwnerBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_lifecycle_owner)

        //将lifecycleOwnerTest的生命周期和当前activity绑定
        //将具有Lifecycle.Event 注解的方法和当前Activity的生命周期进行绑定
        //如果不执行addObserver的话将无法进行绑定
        //lifecycleOwnerTest必须继承LifecycleObs
        lifecycle.addObserver(lifecycleOwnerTest)
        //应用切换前后台调用
//        ProcessLifecycleOwner.get().lifecycle.addObserver(lifecycleOwnerTest)
        DataBinDingLView.name = "LifecycleOwnerTest"
        lifecycleOwnerTest.helloLifecycle();
    }
}