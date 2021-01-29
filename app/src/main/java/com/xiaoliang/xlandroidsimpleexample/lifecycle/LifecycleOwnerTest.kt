package com.xiaoliang.xlandroidsimpleexample.lifecycle

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.*
import com.xiaoliang.xlandroidsimpleexample.base.mContext


/*
*项目名: XLAndroidSimpleExample
*文件名: LifecycleOwnerTest
*创建者: XiaoLiang
*创建时间:2021/1/18 9:42 AM
*描述: 监听生命周期
*/

//继承LifecycleObserver 拥有感应Activity 和 Fragment 的感知能力
class LifecycleOwnerTest : LifecycleObserver {

    fun helloLifecycle() {
        Toast.makeText(mContext, "hello,Lifecycle", Toast.LENGTH_LONG).show()
    }


    //注解：生命周期 能自动感应，无需在Activity内部进行管理
    //代码更加简洁
    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun onCreate() {
        Log.e("LifecycleOwnerTest", "我被创建了")
        Toast.makeText(mContext, "hello,我被创建了", Toast.LENGTH_LONG).show()

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun onDestroy() {
        Log.e("LifecycleOwnerTest", "我被销毁了")
        Toast.makeText(mContext, "hello,我被销毁了", Toast.LENGTH_LONG).show()
    }


    //进入后台
    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    private fun onAppBackground() {
        // 应用进入后台
        Log.e("LifecycleOwnerTest", "LifecycleChecker onAppBackground ON_STOP");
    }

    //进入前台
    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    private fun onAppForeground() {
        // 应用进入前台
        Log.e("LifecycleOwnerTest", "LifecycleChecker onAppForeground ON_START");

    }
}