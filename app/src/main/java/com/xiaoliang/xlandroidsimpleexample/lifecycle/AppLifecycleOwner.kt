package com.xiaoliang.xlandroidsimpleexample.lifecycle

import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent

/*
*项目名: XLAndroidSimpleExample
*文件名: AppLifecycleOwner
*创建者: XiaoLiang
*创建时间:2021/1/18 10:46 AM
*描述: 监听应用的前后台切换
*/
class AppLifecycleOwner : LifecycleObserver {

//  Lifecycle.Event.ON_DESTROY 当前注解不会被调用

    //app启动后调用一次
    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun onCreate() {
        Log.d("AppLifecycleOwner", "当前方法只会被调度一次")
    }

    // 后台 2 优先级
    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun onStop() {
        Log.d("AppLifecycleOwner", "ON_STOP-当前app被切换到后台")
    }

    //前台 1 优先级
    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun onStart() {
        Log.d("AppLifecycleOwner", "ON_START-当前app被切换到前台")
    }

    //前台 2 优先级
    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun onResume() {
        Log.d("AppLifecycleOwner", "ON_RESUME")
    }

    // 后台 1 优先级
    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun onPause() {
        Log.d("AppLifecycleOwner", "onPause")
    }



}