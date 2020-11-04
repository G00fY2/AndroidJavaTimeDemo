package com.g00fy2.androidjavatimedemo

import android.app.Application
import net.danlew.android.joda.JodaTimeAndroid

class MyApp : Application() {

    override fun onCreate() {
        super.onCreate()
        JodaTimeAndroid.init(this)
    }
}