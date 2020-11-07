package com.g00fy2.androidjavatimedemo

import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.TimeZone
import kotlinx.datetime.atStartOfDayIn
import kotlinx.datetime.toInstant
import kotlinx.datetime.toLocalDate
import kotlinx.datetime.toLocalDateTime

object DateParseUtils {

    fun parseDateStrings(dateStrings: Array<String>): List<Pair<String, LocalDateTime?>> {

        return mutableListOf<Pair<String, LocalDateTime?>>().apply {
            dateStrings.forEach {
                // size check is not safe to use
                val date = when {
                    it.length >= 24 -> try {
                        it.toInstant().toLocalDateTime(TimeZone.currentSystemDefault())
                    } catch (e: Exception) {
                        null
                    }
                    it.length >= 18 -> it.toLocalDateTime()
                    else -> it.toLocalDate().atStartOfDayIn(TimeZone.currentSystemDefault()).toLocalDateTime(TimeZone.currentSystemDefault())
                }
                add(Pair(it, date))
            }
        }
    }
}