package com.xiaoliang.xlandroidsimpleexample.room.dao

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.paging.PagedList
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.xiaoliang.xlandroidsimpleexample.room.Animal
import kotlinx.coroutines.flow.Flow

/*
*项目名: XLAndroidSimpleExample
*文件名: AnimalDAO
*创建者: XiaoLiang
*创建时间:2021/1/19 2:09 PM
*描述: TODO
*/
@Dao
interface AnimalDAO {
    @Query("SELECT * FROM animal")
    fun getPlants(): DataSource.Factory<Int, Animal>

    @Query("SELECT * FROM animal WHERE name = :name ORDER BY name")
    fun getPlant(name: String): Flow<Animal>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(plants: List<Animal>)
}