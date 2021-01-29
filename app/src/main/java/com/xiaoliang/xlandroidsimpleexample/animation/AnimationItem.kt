package com.xiaoliang.xlandroidsimpleexample.animation

/*
*项目名: XLAndroidSimpleExample
*文件名: AnimationItem
*创建者: XiaoLiang
*创建时间:2021/1/28 10:36 PM
*描述: 动画数据
*/
data class AnimationItem(
    val id: Int,
    val title: String,
    val image: String
)

private const val LARGE_BASE_URL =
    "https://cn.bing.com/th?id=OHR.ArcticWolf_ZH-CN7307641601_1920x1080.jpg&amp;rf=LaDigue_1920x1080.jpg&amp;pid=hp"
private const val THUMB_BASE_URL =
    "https://cn.bing.com/th?id=OHR.ArcticWolf_ZH-CN7307641601_1920x1080.jpg&amp;rf=LaDigue_1920x1080.jpg&amp;pid=hp"

var ITEMS: Array<AnimationItem> =
    arrayOf<AnimationItem>(
        AnimationItem(
            1,
            "Flying in the Light",
            LARGE_BASE_URL
        ),
        AnimationItem(
            2,
            "Flying in the Light",
            LARGE_BASE_URL
        ),
        AnimationItem(
            3,
            "Flying in the Light",
            LARGE_BASE_URL
        ),
        AnimationItem(
            4,
            "Flying in the Light",
            LARGE_BASE_URL
        ),
        AnimationItem(
            5,
            "Flying in the Light",
            LARGE_BASE_URL
        ),
        AnimationItem(
            6,
            "Flying in the Light",
            LARGE_BASE_URL
        ),
        AnimationItem(
            7,
            "Flying in the Light",
            LARGE_BASE_URL
        ),
        AnimationItem(
            8,
            "Flying in the Light",
            LARGE_BASE_URL
        )
    )

fun getItem(id: Int): AnimationItem? {
    for (item in ITEMS) {
        if (item.id == id) {
            return item
        }
    }
    return null
}

