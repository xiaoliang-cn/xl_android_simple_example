package com.xiaoliang.xlandroidsimpleexample.databinding

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.xiaoliang.xlandroidsimpleexample.R
import kotlinx.android.synthetic.main.activity_data_bin_ding.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class DataBinDingActivity : AppCompatActivity() {

    val dataBinDingViewModel: DataBinDingViewModel by viewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityDataBinDingBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_data_bin_ding)

        //监控生命周期
        binding.lifecycleOwner = this
        /**
         * 绑定数据，数据更新后自动更新ui
         */
        binding.dataBindingViewModel = dataBinDingViewModel

        DataBinDing_Data_Change.setOnClickListener {
            dataBinDingViewModel.onLike()
        }
//        dataBinDingViewModel
    }
}