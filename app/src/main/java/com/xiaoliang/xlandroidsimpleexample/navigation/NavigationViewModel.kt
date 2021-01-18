package com.xiaoliang.xlandroidsimpleexample.navigation

import androidx.lifecycle.ViewModel
import com.xiaoliang.xlandroidsimpleexample.data.DataRepository

class NavigationViewModel(val dataRepository: DataRepository) : ViewModel() {

    fun getData(): MutableList<String> {
        return dataRepository.mnData
    }
}