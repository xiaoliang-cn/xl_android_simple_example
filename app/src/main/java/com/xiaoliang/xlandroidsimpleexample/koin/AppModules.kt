package com.xiaoliang.xlandroidsimpleexample.koin

import com.xiaoliang.xlandroidsimpleexample.data.DataRepository
import com.xiaoliang.xlandroidsimpleexample.databinding.DataBinDingViewModel
import com.xiaoliang.xlandroidsimpleexample.datastore.UserPreferencesRepository
import com.xiaoliang.xlandroidsimpleexample.lifecycle.LifecycleOwnerTest
import com.xiaoliang.xlandroidsimpleexample.navigation.NavigationViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/*
*项目名: XLAndroidSimpleExample
*文件名: AppModules
*创建者: 张小亮
*创建时间:2021/1/16 5:46 PM
*描述: TODO
*/

//注入框架
val appModule = module {
    single { UserPreferencesRepository() }
    single { DataRepository() }
    single { LifecycleOwnerTest() }
    viewModel {
        NavigationViewModel(get())
    }
    viewModel {
        DataBinDingViewModel()
    }
}
