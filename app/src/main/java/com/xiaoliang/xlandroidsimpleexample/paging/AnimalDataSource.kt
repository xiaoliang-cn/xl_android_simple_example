package com.xiaoliang.xlandroidsimpleexample.paging

import android.util.Log
import androidx.paging.ItemKeyedDataSource
import androidx.paging.PageKeyedDataSource
import androidx.paging.toLiveData
import com.xiaoliang.xlandroidsimpleexample.mContext
import com.xiaoliang.xlandroidsimpleexample.room.Animal
import com.xiaoliang.xlandroidsimpleexample.room.AppDatabase
import com.xiaoliang.xlandroidsimpleexample.room.dao.AnimalDAO

/*
*项目名: XLAndroidSimpleExample
*文件名: AnimalDataSource
*创建者: XiaoLiang
*创建时间:2021/1/19 2:56 PM
*描述: TODO
*/
class AnimalDataSource : PageKeyedDataSource<Int, Animal>() {

    override fun loadInitial(
        params: LoadInitialParams<Int>,
        callback: LoadInitialCallback<Int, Animal>
    ) {
//        val li = AppDatabase.getInstance(mContext).ge tAnimalDao().getPlants()
//        Log.d("AnimalDataSource",li.toString())
//        callback.onResult(li.toLiveData(P), null,1)
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, Animal>) {

    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, Animal>) {
        Log.d("loadAfter", params.toString())
        Log.d("loadAfter", callback.toString())
    }

}