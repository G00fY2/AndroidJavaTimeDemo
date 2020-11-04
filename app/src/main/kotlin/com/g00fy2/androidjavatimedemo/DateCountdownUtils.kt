package com.g00fy2.androidjavatimedemo

import java.util.Calendar
import java.util.Date
import java.util.GregorianCalendar
import java.util.Locale
import java.util.TimeZone
import kotlin.math.absoluteValue

object DateCountdownUtils {

    const val TIME_ZONE = "Europe/Berlin"
    private const val SECOND_IN_MILLI = 1000L
    private const val MINUTE_IN_MILLI = SECOND_IN_MILLI * 60
    private const val HOUR_IN_MILLI = MINUTE_IN_MILLI * 60
    private const val DAY_IN_MILLI = HOUR_IN_MILLI * 24

    fun computeCountdownTime(): CountdownResult {
        val calendar = GregorianCalendar(TimeZone.getTimeZone(TIME_ZONE), Locale.GERMANY)
        val currentTime = calendar.time
        val daysDiff = 7 - (calendar[Calendar.DAY_OF_WEEK] - Calendar.SUNDAY)

        calendar.set(Calendar.HOUR_OF_DAY, 19)
        calendar.set(Calendar.MINUTE, 0)
        calendar.set(Calendar.SECOND, 0)
        calendar.set(Calendar.MILLISECOND, 0)

        calendar.add(Calendar.DAY_OF_MONTH, daysDiff)
        if (calendar.time.before(currentTime)) {
            calendar.add(Calendar.DAY_OF_MONTH, 7)
        }

        var diff = calendar.timeInMillis - currentTime.time + SECOND_IN_MILLI
        val days = (diff / DAY_IN_MILLI).toInt().absoluteValue
        diff %= DAY_IN_MILLI
        val hours = (diff / HOUR_IN_MILLI).toInt().absoluteValue
        diff %= HOUR_IN_MILLI
        val minutes = (diff / MINUTE_IN_MILLI).toInt().absoluteValue
        diff %= MINUTE_IN_MILLI
        val seconds = (diff / SECOND_IN_MILLI).toInt().absoluteValue

        return CountdownResult(currentTime, calendar.time, CountdownTime(days, hours, minutes, seconds))
    }

    data class CountdownResult(val currentTime: Date, val countdownEndTime: Date, val countdownTick: CountdownTime)

    data class CountdownTime(val days: Int, val hours: Int, val minutes: Int, val seconds: Int) {
        override fun toString() = "$days days : $hours hr : $minutes min : $seconds sec"
    }
}