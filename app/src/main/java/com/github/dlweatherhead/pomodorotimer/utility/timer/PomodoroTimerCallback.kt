package com.github.dlweatherhead.pomodorotimer.utility.timer

interface PomodoroTimerCallback {
    fun timerTickCallback(millisUntilFinished: Long)
    fun timerFinishedCallback()
}