package com.g00fy2.androidjavatimedemo

import kotlinx.datetime.Clock
import kotlinx.datetime.DateTimeUnit
import kotlinx.datetime.DayOfWeek
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.TimeZone
import kotlinx.datetime.plus
import kotlinx.datetime.toInstant
import kotlinx.datetime.toLocalDateTime
import kotlin.time.DurationUnit
import kotlin.time.ExperimentalTime
import kotlin.time.toDuration

@ExperimentalTime
object DateCountdownUtils {

    const val TIME_ZONE = "Europe/Berlin"

    fun computeCountdownTime(): CountdownResult {
        val now = Clock.System.now()
        val currentDateTime = now.toLocalDateTime(TimeZone.of(TIME_ZONE))
        var countdownDateTime = LocalDateTime(currentDateTime.year, currentDateTime.month, currentDateTime.dayOfMonth, 19, 0, 0, 0)
        val daysDiff = DayOfWeek.SUNDAY.value - currentDateTime.dayOfWeek.value

        countdownDateTime = countdownDateTime.toInstant(TimeZone.of(TIME_ZONE)).plus(daysDiff, DateTimeUnit.DAY, TimeZone.of(TIME_ZONE)).toLocalDateTime(TimeZone.of(TIME_ZONE))
        if (countdownDateTime < currentDateTime) {
            countdownDateTime = countdownDateTime.toInstant(TimeZone.of(TIME_ZONE)).plus(7, DateTimeUnit.DAY, TimeZone.of(TIME_ZONE)).toLocalDateTime(TimeZone.of(TIME_ZONE))
        }

        var duration = countdownDateTime.toInstant(TimeZone.of(TIME_ZONE)).plus(1, DateTimeUnit.SECOND, TimeZone.of(TIME_ZONE)) - now
        val days = duration.inDays.toInt()
        duration = duration.minus(days.toDuration(DurationUnit.DAYS))
        val hours = duration.inHours.toInt()
        duration = duration.minus(hours.toDuration(DurationUnit.HOURS))
        val minutes = duration.inMinutes.toInt()
        duration = duration.minus(minutes.toDuration(DurationUnit.MINUTES))
        val seconds = duration.inSeconds.toInt()

        return CountdownResult(currentDateTime, countdownDateTime, CountdownTime(days, hours, minutes, seconds))
    }

    data class CountdownResult(val currentTime: LocalDateTime, val countdownEndTime: LocalDateTime, val countdownTick: CountdownTime)

    data class CountdownTime(val days: Int, val hours: Int, val minutes: Int, val seconds: Int) {
        override fun toString() = "$days days : $hours hr : $minutes min : $seconds sec"
    }
}