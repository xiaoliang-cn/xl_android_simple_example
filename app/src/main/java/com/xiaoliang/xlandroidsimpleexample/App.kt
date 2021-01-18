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
*创建者: 张小亮
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

        ProcessLifecycleOwner.get().lifecycle.addObserver(AppLifecycleOwner())


    }

}