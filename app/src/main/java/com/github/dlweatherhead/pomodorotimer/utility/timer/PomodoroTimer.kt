package com.github.dlweatherhead.pomodorotimer.utility.timer

import android.os.CountDownTimer

/**
 * Custom Timer for counting down in milliseconds at fixed intervals.
 * This custom Timer required Tick and Finished Callbacks. Making it injectable and testable.
 */
class PomodoroTimer(
    counterStart: Long,
    counterInterval: Long,
    private val callbacks: PomodoroTimerCallback
) :
    CountDownTimer(counterStart, counterInterval) {
    override fun onFinish() {
        callbacks.timerFinishedCallback()
    }

    override fun onTick(millisUntilFinished: Long) {
        callbacks.timerTickCallback(millisUntilFinished)
    }

}