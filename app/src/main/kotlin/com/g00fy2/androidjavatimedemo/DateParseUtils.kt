package com.g00fy2.androidjavatimedemo

import org.threeten.bp.LocalDate
import org.threeten.bp.LocalDateTime
import org.threeten.bp.OffsetDateTime
import org.threeten.bp.ZoneId
import org.threeten.bp.format.DateTimeFormatter

object DateParseUtils {

    fun parseDateStrings(dateStrings: Array<String>): List<Pair<String, LocalDateTime>> {

        return mutableListOf<Pair<String, LocalDateTime>>().apply {
            dateStrings.forEach {
                // size check is not safe to use
                val date = when {
                    it.length >= 24 -> OffsetDateTime.parse(it, DateTimeFormatter.ISO_DATE_TIME).atZoneSameInstant(ZoneId.systemDefault()).toLocalDateTime()
                    it.length >= 18 -> LocalDateTime.parse(it, DateTimeFormatter.ISO_DATE_TIME)
                    else -> LocalDate.parse(it, DateTimeFormatter.ISO_DATE).atStartOfDay()
                }
                add(Pair(it, date))
            }
        }
    }
}