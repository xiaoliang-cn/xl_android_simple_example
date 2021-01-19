package com.xiaoliang.xlandroidsimpleexample.room

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.google.gson.Gson
import com.google.gson.annotations.Until
import com.google.gson.reflect.TypeToken
import com.google.gson.stream.JsonReader
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow

/*
*项目名: XLAndroidSimpleExample
*文件名: InitWork
*创建者: XiaoLiang
*创建时间:2021/1/19 2:27 PM
*描述: ROOM 执行一次初始化任务，使用workManger
*/
class InitWork(context: Context, workerParams: WorkerParameters) :
    CoroutineWorker(context, workerParams) {


    override suspend fun doWork(): Result = coroutineScope {
        try {
            applicationContext.assets.open("plants.json").use {
                JsonReader(it.reader()).use { jsonR ->
                    val ts = object : TypeToken<List<Animal>>() {}.type
                    val animals: List<Animal> = Gson().fromJson(jsonR, ts)
                    val database = AppDatabase.getInstance(applicationContext)
                    database.getAnimalDao().insertAll(animals)
                }
            }
            Result.success()

        } catch (e: Exception) {


            Result.failure()
        }
    }
}