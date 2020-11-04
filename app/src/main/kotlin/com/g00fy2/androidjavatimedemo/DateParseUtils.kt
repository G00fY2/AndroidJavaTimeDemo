package com.g00fy2.androidjavatimedemo

import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter


object DateParseUtils {

    fun parseDateStrings(dateStrings: Array<String>): List<Pair<String, LocalDateTime>> {

        return mutableListOf<Pair<String, LocalDateTime>>().apply {
            dateStrings.forEach {
                // size check is not safe to use
                val date = when {
                    it.length >= 18 -> LocalDateTime.parse(it, DateTimeFormatter.ISO_DATE_TIME)
                    else -> LocalDate.parse(it, DateTimeFormatter.ISO_DATE).atStartOfDay()
                }
                add(Pair(it, date))
            }
        }
    }
}