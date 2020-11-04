package com.g00fy2.androidjavatimedemo

import org.threeten.bp.DayOfWeek
import org.threeten.bp.Duration
import org.threeten.bp.Instant
import org.threeten.bp.LocalDateTime
import org.threeten.bp.ZoneId
import java.util.Date

object DateCountdownUtils {

    const val TIME_ZONE = "Europe/Berlin"

    fun computeCountdownTime(): CountdownResult {
        val currentDateMillis = Date().time
        val currentDateTime = Instant.ofEpochMilli(currentDateMillis).atZone(ZoneId.of(TIME_ZONE)).toLocalDateTime()
        var countdownDateTime = Instant.ofEpochMilli(currentDateMillis).atZone(ZoneId.of(TIME_ZONE)).toLocalDateTime().withHour(19).withMinute(0).withSecond(0).withNano(0)
        val daysDiff = DayOfWeek.SUNDAY.value - currentDateTime.dayOfWeek.value

        countdownDateTime = countdownDateTime.plusDays(daysDiff.toLong())
        if (countdownDateTime.isBefore(currentDateTime)) {
            countdownDateTime = countdownDateTime.plusDays(7)
        }

        var duration = Duration.between(currentDateTime, countdownDateTime.plusSeconds(1))
        val days = duration.toDays()
        duration = duration.minusDays(days)
        val hours = duration.toHours()
        duration = duration.minusHours(hours)
        val minutes = duration.toMinutes()
        duration = duration.minusMinutes(minutes)
        val seconds = duration.seconds

        return CountdownResult(currentDateTime, countdownDateTime, CountdownTime(days.toInt(), hours.toInt(), minutes.toInt(), seconds.toInt()))
    }

    data class CountdownResult(val currentTime: LocalDateTime, val countdownEndTime: LocalDateTime, val countdownTick: CountdownTime)

    data class CountdownTime(val days: Int, val hours: Int, val minutes: Int, val seconds: Int) {
        override fun toString() = "$days days : $hours hr : $minutes min : $seconds sec"
    }
}