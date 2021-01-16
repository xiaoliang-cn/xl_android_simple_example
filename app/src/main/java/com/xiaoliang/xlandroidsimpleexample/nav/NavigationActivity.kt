package com.xiaoliang.xlandroidsimpleexample.nav

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.Navigation
import com.xiaoliang.xlandroidsimpleexample.R

class NavigationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navigation)
        val navController = Navigation.findNavController(this, R.id.navigationFragment)
        navController.addOnDestinationChangedListener { controller, destination, arguments ->
            //监听导航连接

        }
        //NavigationUI 支持以下顶部应用栏类型：
        //Toolbar
        //CollapsingToolbarLayout
        //ActionBar
        //val appBarConfiguration = AppBarConfiguration(navController.graph)
        //val appBarConfiguration = AppBarConfiguration(setOf(R.id.main, R.id.profile))


        //NavigationUI 还提供帮助程序，用于将目的地关联到菜单驱动的界面组件。
        // NavigationUI 包含一个帮助程序方法 onNavDestinationSelected()，
        // 该方法使用 MenuItem 以及托管关联目的地的 NavController。
        // 如果 MenuItem 的 id 与目的地的 id 匹配，NavController 可以导航至该目的地。
        //
        //例如，下面的 XML 代码段使用常见的 id 和 details_page_fragment 定义菜单项及目的地：
    }
}