package com.xiaoliang.xlandroidsimpleexample.datastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.core.DataStoreFactory
import androidx.datastore.createDataStore
import androidx.datastore.preferences.createDataStore
import com.xiaoliang.xlandroidsimpleexample.mContext
import java.util.prefs.Preferences

/*
*项目名: XLAndroidSimpleExample
*文件名: DataPreferences
*创建者: 张小亮
*创建时间:2021/1/15 7:39 PM
*描述: TODO
*/
object DataPreferences {

    val dataStore = mContext.createDataStore(
        fileName = "user_prefs.pb",
        serializer = UserPreferencesSerializer()
    )


    val dataUserStore = mContext.createDataStore("settings")

}

