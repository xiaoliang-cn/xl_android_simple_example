package com.xiaoliang.xlandroidsimpleexample.navigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.xiaoliang.xlandroidsimpleexample.R
import com.xiaoliang.xlandroidsimpleexample.adapter.SimpleAdapter
import kotlinx.android.synthetic.main.navigation_fragment.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class NavigationFragment : Fragment() {

    companion object {
        fun newInstance() = NavigationFragment()
    }

    //koin 依赖注入
    val navigationViewModel: NavigationViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.navigation_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        nav_fragment_recycler.adapter = SimpleAdapter(navigationViewModel.getData())
        nav_navigation_fragment2_button.setOnClickListener {
            findNavController().navigate(R.id.action_navigationFragment_to_navigation2Fragment2)
        }
    }

}