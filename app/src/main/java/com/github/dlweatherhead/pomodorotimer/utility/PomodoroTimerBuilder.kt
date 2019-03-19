package com.github.dlweatherhead.pomodorotimer.utility

import android.os.CountDownTimer

open class PomodoroTimerBuilder {
    open fun create(
        counterStart: Long,
        counterInterval: Long,
        callbacks: PomodoroTimerCallback
    )
            : CountDownTimer {
        return PomodoroTimer(
            counterStart,
            counterInterval,
            callbacks
        )
    }
}