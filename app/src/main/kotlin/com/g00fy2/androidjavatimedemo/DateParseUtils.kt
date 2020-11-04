package com.g00fy2.androidjavatimedemo

import org.joda.time.DateTime
import org.joda.time.format.ISODateTimeFormat

object DateParseUtils {

    fun parseDateStrings(dateStrings: Array<String>): List<Pair<String, DateTime>> {
        return mutableListOf<Pair<String, DateTime>>().apply {
            dateStrings.forEach {
                add(Pair(it, ISODateTimeFormat.dateOptionalTimeParser().parseDateTime(it)))
            }
        }
    }
}