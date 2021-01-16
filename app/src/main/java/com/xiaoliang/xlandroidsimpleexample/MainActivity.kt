package com.xiaoliang.xlandroidsimpleexample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.xiaoliang.xlandroidsimpleexample.datastore.UserPreferencesRepository
import com.xiaoliang.xlandroidsimpleexample.nav.NavigationActivity
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        storeExample()
        navigationExample()
    }

    private fun navigationExample() {
        navigation_example.setOnClickListener {
            val intent = Intent(this, NavigationActivity::class.java)
            startActivity(intent)

        }
    }

    private fun storeExample() {
        data_store_example.setOnClickListener {
            val intent = Intent(this, DataStoreSimpleExample::class.java)
            startActivity(intent)
        }

    }
}