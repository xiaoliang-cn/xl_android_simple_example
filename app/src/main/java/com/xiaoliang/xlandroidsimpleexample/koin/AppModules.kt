package com.xiaoliang.xlandroidsimpleexample.koin

import com.xiaoliang.xlandroidsimpleexample.datastore.UserPreferencesRepository
import com.xiaoliang.xlandroidsimpleexample.datastore.UsersPreferences
import org.koin.dsl.module

/*
*项目名: XLAndroidSimpleExample
*文件名: AppModules
*创建者: 张小亮
*创建时间:2021/1/16 5:46 PM
*描述: TODO
*/

val appModule = module {
    single { UserPreferencesRepository() }

}