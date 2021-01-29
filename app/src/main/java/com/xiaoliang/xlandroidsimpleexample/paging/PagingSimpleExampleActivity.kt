package com.xiaoliang.xlandroidsimpleexample.paging

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.xiaoliang.xlandroidsimpleexample.R
import com.xiaoliang.xlandroidsimpleexample.room.AppDatabase
import com.xiaoliang.xlandroidsimpleexample.toast
import kotlinx.android.synthetic.main.activity_paging_simple_example.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel


class PagingSimpleExampleActivity : AppCompatActivity() {

    lateinit var pagingViewModel: PagingViewModel

    val adapter = PagingAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_paging_simple_example)
        paging_recycler.adapter = adapter
        pagingViewModel = ViewModelProviders.of(this).get(PagingViewModel::class.java)
        pagingViewModel.l.observe(this, Observer {
            Log.d("AnimalDataSource=av=111", it.size.toString())
            adapter.submitList(it)
        })
//        val a = appDatabase.getAnimalDao()
//        toast(a.toString())

    }

}