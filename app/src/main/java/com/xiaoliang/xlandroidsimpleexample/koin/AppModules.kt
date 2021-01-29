package com.xiaoliang.xlandroidsimpleexample.koin

import com.xiaoliang.xlandroidsimpleexample.data.DataRepository
import com.xiaoliang.xlandroidsimpleexample.databinding.DataBinDingViewModel
import com.xiaoliang.xlandroidsimpleexample.datastore.UserPreferencesRepository
import com.xiaoliang.xlandroidsimpleexample.lifecycle.LifecycleOwnerTest
import com.xiaoliang.xlandroidsimpleexample.navigation.NavigationViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import com.xiaoliang.xlandroidsimpleexample.paging.PagingViewModel
import com.xiaoliang.xlandroidsimpleexample.room.AppDatabase
import com.xiaoliang.xlandroidsimpleexample.room.AppDatabase_Impl
import com.xiaoliang.xlandroidsimpleexample.room.dao.AnimalDAO
import com.xiaoliang.xlandroidsimpleexample.room.dao.AnimalDAO_Impl

/*
*项目名: XLAndroidSimpleExample
*文件名: AppModules
*创建者: XiaoLiang
*创建时间:2021/1/16 5:46 PM
*描述: TODO
*/

//注入框架
val appModule = module {
    single { UserPreferencesRepository() }
    single { DataRepository() }
    single { LifecycleOwnerTest() }
    single<AppDatabase> { AppDatabase_Impl() }

    viewModel {
        NavigationViewModel(get())
    }
    viewModel {
        DataBinDingViewModel()
    }
}
