package com.g00fy2.androidjavatimedemo

import android.annotation.SuppressLint
import java.text.SimpleDateFormat
import java.util.Date

object DateParseUtils {

    @SuppressLint("SimpleDateFormat")
    fun parseDateStrings(dateStrings: Array<String>): List<Pair<String, Date>> {
        val dateTimeFormatZone = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
        val dateTimeFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss")
        val dateFormat = SimpleDateFormat("yyyy-MM-dd")

        return mutableListOf<Pair<String, Date>>().apply {
            dateStrings.forEach {
                // size check is not safe to use
                val date = when {
                    it.length >= 24 -> dateTimeFormatZone.parse(it)
                    it.length >= 18 -> dateTimeFormat.parse(it)
                    else -> dateFormat.parse(it)
                }

                add(Pair(it, date!!))
            }
        }
    }
}