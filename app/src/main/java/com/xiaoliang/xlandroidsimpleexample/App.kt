package com.xiaoliang.xlandroidsimpleexample

import android.app.Application
import android.content.Context
import android.util.Log
import androidx.lifecycle.*
import com.xiaoliang.xlandroidsimpleexample.koin.appModule
import com.xiaoliang.xlandroidsimpleexample.lifecycle.AppLifecycleOwner
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidFileProperties
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

/*
*项目名: XLAndroidSimpleExample
*文件名: App
*创建者: XiaoLiang
*创建时间:2021/1/15 7:41 PM
*描述: TODO
*/
//简单的全局获取上下文
lateinit var mContext: Context

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        mContext = applicationContext
        startKoin {
            androidLogger(Level.DEBUG)
            androidContext(applicationContext)
            androidFileProperties()
            modules(appModule)
        }

        /**
         * 提供整个应用程序生命周期的类。
        您可以将这个LifecycleOwner视为您所有Activity的组合，
        只是 Lifecycle.Event.ON_CREATE它将被调度一次，
        并且Lifecycle.Event.ON_DESTROY 永远不会被调度。
        其他生命周期事件将与以下原则分派：ProcessLifecycleOwner将出动Lifecycle.Event.ON_START，
        Lifecycle.Event.ON_RESUME活动，
        通过这些活动第一活性移动。 Lifecycle.Event.ON_PAUSE，
        Lifecycle.Event.ON_STOP事件将在上一个活动通过后延迟发送。此延迟足够长，
        以确保如果由于配置更改而破坏并重新创建活动，则ProcessLifecycleOwner将不会发送任何事件。
        当您希望对即将到来的应用程序或即将进入到后台的应用程序做出反应，
        并且在接收生命周期事件时不需要毫秒级的精度时，此功能非常有用。
         */
        ProcessLifecycleOwner.get().lifecycle.addObserver(AppLifecycleOwner())


    }

}