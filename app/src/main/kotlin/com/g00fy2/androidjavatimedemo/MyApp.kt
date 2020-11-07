package com.g00fy2.androidjavatimedemo

import androidx.multidex.MultiDexApplication
import net.danlew.android.joda.JodaTimeAndroid

class MyApp : MultiDexApplication() {

    override fun onCreate() {
        super.onCreate()
        JodaTimeAndroid.init(this)
    }
}