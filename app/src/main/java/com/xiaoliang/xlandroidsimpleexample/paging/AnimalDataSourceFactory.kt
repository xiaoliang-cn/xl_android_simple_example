package com.xiaoliang.xlandroidsimpleexample.paging

import androidx.paging.DataSource
import com.xiaoliang.xlandroidsimpleexample.room.Animal


/*
*项目名: XLAndroidSimpleExample
*文件名: AnimalDataSource
*创建者: XiaoLiang
*创建时间:2021/1/19 2:56 PM
*描述: TODO
*/
class AnimalDataSourceFactory : DataSource.Factory<Int, Animal>() {
    override fun create(): DataSource<Int, Animal> {
        return AnimalDataSource()
    }

}