package com.github.dlweatherhead.pomodorotimer.utility.timer

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