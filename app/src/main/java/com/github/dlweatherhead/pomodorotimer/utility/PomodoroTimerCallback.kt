package com.github.dlweatherhead.pomodorotimer.utility

interface PomodoroTimerCallback {
    fun timerTickCallback(millisUntilFinished: Long)
    fun timerFinishedCallback()
}