package com.xiaoliang.xlandroidsimpleexample.datastore

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import androidx.datastore.preferences.core.preferencesKey
import androidx.datastore.preferences.createDataStore
import com.xiaoliang.xlandroidsimpleexample.UserPreferences
import com.xiaoliang.xlandroidsimpleexample.mContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import java.io.IOException

/*
*项目名: XLAndroidSimpleExample
*文件名: UsersPreferences
*创建者: 张小亮
*创建时间:2021/1/16 5:34 PM
*描述: TODO
*/
data class UsersPreferences(
    val name: String,
    val age: Int
)

private val dataStoreS: DataStore<Preferences> = mContext
    .createDataStore(name = "user")

class UserPreferencesRepository {


    private object PreferencesKeys {
        val SHOW_NAME = preferencesKey<String>("name")
        val SHOW_AGE = preferencesKey<Int>("age")
    }

    val userPreferencesFlow: Flow<UsersPreferences> =
        dataStoreS.data.catch { exc ->
            //异常处理
            if (exc is IOException) {
                emit(emptyPreferences())
            } else {
                throw  exc
            }
        }
            .map { preferences ->
                val shaComplete = preferences[PreferencesKeys.SHOW_NAME] ?: "小亮"
                val age = preferences[PreferencesKeys.SHOW_AGE] ?: 1
                UsersPreferences(shaComplete, age)
            }


    suspend fun updateShowCompleted(name: String,age:Int) {
        dataStoreS.edit { preferences ->
            preferences[PreferencesKeys.SHOW_NAME] = name
            preferences[PreferencesKeys.SHOW_AGE] = age
        }
    }
}