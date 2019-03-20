package com.github.dlweatherhead.pomodorotimer.view

import java.util.concurrent.TimeUnit

class TimeFormatUtility {

    companion object {
        const val STANDARD_TIME_FORMAT = "%02d:%02d"
    }

    fun convertToStandardTime(milliseconds: Long): String {
        val minutes = TimeUnit.MILLISECONDS.toMinutes(milliseconds)
        val totalSeconds = TimeUnit.MILLISECONDS.toSeconds(milliseconds)
        val minuteSeconds = TimeUnit.MINUTES.toSeconds(minutes)

        return String.format(STANDARD_TIME_FORMAT, minutes, totalSeconds - minuteSeconds)
    }

}