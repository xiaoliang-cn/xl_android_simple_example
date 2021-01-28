package com.xiaoliang.xlandroidsimpleexample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.xiaoliang.xlandroidsimpleexample.databinding.DataBinDingActivity
import com.xiaoliang.xlandroidsimpleexample.lifecycle.LifecycleOwnerActivity
import com.xiaoliang.xlandroidsimpleexample.navigation.NavigationActivity
import kotlinx.android.synthetic.main.activity_main.*
import com.xiaoliang.xlandroidsimpleexample.paging.PagingSimpleExampleActivity
import com.xiaoliang.xlandroidsimpleexample.springanimation.SpringAnimationActivity

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

        //com.xiaoliang.xlandroidsimpleexample.paging example
        pagingExample()

        //联系人滑动效果
        //model 例子 单独运行

        //弹簧动画效果
        springAnimation()
    }

    private fun springAnimation() {
        contacts_scroll.setOnClickListener {
            val intent = Intent(this, SpringAnimationActivity::class.java)
            startActivity(intent)
        }
    }


    private fun pagingExample() {
        pagingExample.setOnClickListener {
            val intent = Intent(this, PagingSimpleExampleActivity::class.java)
            startActivity(intent)
        }

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