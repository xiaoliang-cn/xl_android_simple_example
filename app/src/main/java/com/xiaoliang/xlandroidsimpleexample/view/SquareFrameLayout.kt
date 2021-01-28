package com.xiaoliang.xlandroidsimpleexample.view

import android.content.Context
import android.util.AttributeSet
import android.widget.FrameLayout

/*
*项目名: XLAndroidSimpleExample
*文件名: SquareFrameLayout
*创建者: XiaoLiang
*创建时间:2021/1/28 10:05 PM
*描述: TODO
*/
class SquareFrameLayout(context: Context, attributes: AttributeSet) :
    FrameLayout(context, attributes) {
    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        val widthSize = MeasureSpec.getSize(widthMeasureSpec)
        val heightSize = MeasureSpec.getSize(heightMeasureSpec)
        if(widthSize == 0 && heightSize == 0){
            super.onMeasure(widthMeasureSpec, heightMeasureSpec)
            
            val minSize = measuredWidth.coerceAtMost(measuredHeight)
            setMeasuredDimension(widthMeasureSpec, heightMeasureSpec)
            return;
        }
        var size = 0
        if(widthSize == 0 || heightSize ==0){
            size = widthSize.coerceAtLeast(heightSize)
        }else{
            size = Math.min(widthSize, heightSize)
        }
        val newMeasureSpe = MeasureSpec.makeMeasureSpec(size, MeasureSpec.EXACTLY)
        super.onMeasure(newMeasureSpe, newMeasureSpe)
    }
}