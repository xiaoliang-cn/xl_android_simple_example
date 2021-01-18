package com.xiaoliang.xlandroidsimpleexample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.xiaoliang.xlandroidsimpleexample.databinding.DataBinDingActivity
import com.xiaoliang.xlandroidsimpleexample.lifecycle.LifecycleOwnerActivity
import com.xiaoliang.xlandroidsimpleexample.lifecycle.LifecycleOwnerTest
import com.xiaoliang.xlandroidsimpleexample.navigation.NavigationActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //data store
        storeExample()
        //nav
        navigationExample()
        //databinding
        databindingExample()

        //lifecycleOwner
        lifecycleOwnerExample()
    }

    private fun lifecycleOwnerExample() {
        lifecycleOwner_example.setOnClickListener {
            val intent = Intent(this, LifecycleOwnerActivity::class.java)
            startActivity(intent)

        }

    }

    private fun databindingExample() {
        dataBinDing_example.setOnClickListener {
            val intent = Intent(this, DataBinDingActivity::class.java)
            startActivity(intent)

        }
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