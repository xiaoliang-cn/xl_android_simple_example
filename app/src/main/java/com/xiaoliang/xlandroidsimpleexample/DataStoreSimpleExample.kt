package com.xiaoliang.xlandroidsimpleexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.datastore.preferences.core.edit
import com.xiaoliang.xlandroidsimpleexample.datastore.DataPreferences
import com.xiaoliang.xlandroidsimpleexample.datastore.UserPreferencesRepository
import com.xiaoliang.xlandroidsimpleexample.datastore.UsersPreferences
import kotlinx.android.synthetic.main.activity_data_store_simple_example.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject

class DataStoreSimpleExample : AppCompatActivity() {
    val userPreferencesRepository: UserPreferencesRepository by inject()
    lateinit var usersPreferences: UsersPreferences
    var i = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_data_store_simple_example)


        GlobalScope.launch {
            userPreferencesRepository.userPreferencesFlow.first().apply {
                println("这里到底执行不执行")
                usersPreferences = this
                runOnUiThread {
                    dataStore_XS1.text = this.name + "===" + this.age
                }
            }
        }


        //key value
        DataStore_Button1.setOnClickListener {
            i++
            toast("刷新界面111=${usersPreferences.toString()}")
            GlobalScope.launch {
                userPreferencesRepository.updateShowCompleted("小亮---$i", i++)
                userPreferencesRepository.userPreferencesFlow.first().apply {
                    runOnUiThread {
                        dataStore_XS1.text = this.name + "===" + this.age
                    }
                }
            }
        }

        GlobalScope.launch {
            val user = DataPreferences.dataStore.data.first()
            runOnUiThread {
                dataStore_XS.text = user.showCompleted.toString()
            }
        }
        DataStore_Button.setOnClickListener {
            GlobalScope.launch {

                updateInfo(false)
            }
        }
    }

    suspend fun updateInfo(comple: Boolean) {
//        DataPreferences.dataStore.updateData {
//            println("updateInfo" + it.showCompleted.toString())
//            it.toBuilder().setShowCompleted(!it.showCompleted).build()
//        }
        GlobalScope.launch {
            val user = DataPreferences.dataStore.data.first()
            runOnUiThread {
                dataStore_XS.text = user.showCompleted.toString()
            }
        }
    }


}