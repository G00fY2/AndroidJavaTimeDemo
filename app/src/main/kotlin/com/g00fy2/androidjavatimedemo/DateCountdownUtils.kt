package com.g00fy2.androidjavatimedemo

import org.joda.time.DateTime
import org.joda.time.DateTimeConstants
import org.joda.time.DateTimeZone
import org.joda.time.Days
import org.joda.time.Hours
import org.joda.time.Minutes
import org.joda.time.Seconds
import java.util.Date

object DateCountdownUtils {

    private const val TIME_ZONE = "Europe/Berlin"

    fun computeCountdownTime(): CountdownResult {
        val currentDateMillis = Date().time
        val currentDateTime = DateTime(currentDateMillis, DateTimeZone.forID(TIME_ZONE))
        var countdownDateTime = DateTime(currentDateMillis, DateTimeZone.forID(TIME_ZONE)).withTime(19, 0, 1, 0)
        val daysDiff = DateTimeConstants.SUNDAY - currentDateTime.dayOfWeek

        countdownDateTime = countdownDateTime.plusDays(daysDiff)
        if (countdownDateTime.isBefore(currentDateTime)) {
            countdownDateTime = countdownDateTime.plusDays(7)
        }

        var diffDate = currentDateTime
        val days = Days.daysBetween(diffDate, countdownDateTime).days
        diffDate = diffDate.plusDays(days)
        val hours = Hours.hoursBetween(diffDate, countdownDateTime).hours
        diffDate = diffDate.plusHours(hours)
        val minutes = Minutes.minutesBetween(diffDate, countdownDateTime).minutes
        diffDate = diffDate.plusMinutes(minutes)
        val seconds = Seconds.secondsBetween(diffDate, countdownDateTime).seconds

        return CountdownResult(currentDateTime, countdownDateTime, CountdownTime(days, hours, minutes, seconds))
    }

    data class CountdownResult(val currentTime: DateTime, val countdownEndTime: DateTime, val countdownTick: CountdownTime)

    data class CountdownTime(val days: Int, val hours: Int, val minutes: Int, val seconds: Int) {
        override fun toString() = "$days days : $hours hr : $minutes min : $seconds sec"
    }
}