package com.xiaoliang.xlandroidsimpleexample.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverter
import androidx.sqlite.db.SupportSQLiteDatabase
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import com.xiaoliang.xlandroidsimpleexample.room.dao.AnimalDAO

/*
*项目名: XLAndroidSimpleExample
*文件名: AppDatabase
*创建者: XiaoLiang
*创建时间:2021/1/19 2:12 PM
*描述: TODO
*/

@Database(entities = [Animal::class], version = 1, exportSchema = false)
abstract class AppDatabase  : RoomDatabase()  {
    abstract fun getAnimalDao(): AnimalDAO

    companion object {
        @Volatile
        private var instance: AppDatabase? = null
        fun getInstance(context: Context): AppDatabase {
            return instance ?: synchronized(this) {
                instance ?: buildDatabase(context).also { instance = it }
            }
        }

        // Create and pre-populate the database. See this article for more details:
        // https://medium.com/google-developers/7-pro-tips-for-room-fbadea4bfbd1#4785
        private fun buildDatabase(context: Context) :AppDatabase{
           return   Room.databaseBuilder(context, AppDatabase::class.java, "test-db")
                .addCallback(
                    object : RoomDatabase.Callback() {
                        override fun onCreate(db: SupportSQLiteDatabase) {
                            super.onCreate(db)
                            //这里使用了jetpack- WorkManager库
                            val request = OneTimeWorkRequestBuilder<InitWork>().build()
                            WorkManager.getInstance(context).enqueue(request)
                        }
                    }
                ).build()
        }
    }
}