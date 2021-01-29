package com.xiaoliang.xlandroidsimpleexample

import android.widget.Toast
import com.xiaoliang.xlandroidsimpleexample.base.mContext

/*
*项目名: XLAndroidSimpleExample
*文件名: Utils
*创建者: XiaoLiang
*创建时间:2021/1/16 5:59 PM
*描述: TODO
*/

fun toast(msg: String) = Toast.makeText(mContext, msg, Toast.LENGTH_LONG).show()