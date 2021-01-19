package com.xiaoliang.xlandroidsimpleexample.room

import android.os.Parcel
import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/*
*项目名: XLAndroidSimpleExample
*文件名: animal
*创建者: XiaoLiang
*创建时间:2021/1/19 1:58 PM
*描述: TODO
*/
//
@Entity(tableName = "animal")
data class Animal(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    @ColumnInfo(name = "name")
    val name: String,
    @ColumnInfo(name = "age")
    val age: Int,
    @ColumnInfo(name = "content")

    val content: String,
    @ColumnInfo(name = "type")

    val type: String = "动物",
    @ColumnInfo(name = "image")

    val image: String
)