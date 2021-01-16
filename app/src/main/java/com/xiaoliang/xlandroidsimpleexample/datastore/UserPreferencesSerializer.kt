package com.xiaoliang.xlandroidsimpleexample.datastore

import androidx.datastore.core.CorruptionException
import androidx.datastore.core.Serializer
import com.xiaoliang.xlandroidsimpleexample.UserPreferences
import java.io.InputStream
import java.io.OutputStream
import java.util.*

/*
*项目名: XLAndroidSimpleExample
*文件名: UserPreferencesSerializer
*创建者: 张小亮
*创建时间:2021/1/15 8:04 PM
*描述: TODO
*/
class UserPreferencesSerializer : Serializer<UserPreferences> {
    override val defaultValue: UserPreferences
        get() = UserPreferences.getDefaultInstance()

    override fun readFrom(input: InputStream): UserPreferences {
        try {
            return UserPreferences.parseFrom(input)
        } catch (exception: InvalidPropertiesFormatException) {
            throw CorruptionException("Cannot read proto.", exception)
        }
    }

    override fun writeTo(t: UserPreferences, output: OutputStream) = t.writeTo(output)
}