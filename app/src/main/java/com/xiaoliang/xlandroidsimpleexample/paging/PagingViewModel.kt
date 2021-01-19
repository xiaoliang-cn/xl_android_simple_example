package com.xiaoliang.xlandroidsimpleexample.paging

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import androidx.paging.toLiveData
import com.xiaoliang.xlandroidsimpleexample.mContext
import com.xiaoliang.xlandroidsimpleexample.room.Animal
import com.xiaoliang.xlandroidsimpleexample.room.AppDatabase
import org.koin.android.ext.android.inject
import org.koin.experimental.property.inject


/*
*项目名: XLAndroidSimpleExample
*文件名: PagingViewModel
*创建者: XiaoLiang
*创建时间:2021/1/19 3:10 PM
*描述: TODO
*/
class PagingViewModel() : ViewModel() {

    //    val animalLiveData: LiveData<PagedList<Animal>> = AnimalDataSourceFactory().toLiveData(1)
    val li = AppDatabase.getInstance(mContext).getAnimalDao().getPlants()
    val l: LiveData<PagedList<Animal>> = li.toLiveData(pageSize = 1)
}