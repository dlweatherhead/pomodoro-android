package com.github.dlweatherhead.pomodorotimer

import android.arch.lifecycle.ViewModel
import android.databinding.ObservableBoolean
import android.databinding.ObservableLong
import com.github.dlweatherhead.pomodorotimer.utility.PomodoroTimerBuilder
import com.github.dlweatherhead.pomodorotimer.utility.PomodoroTimerCallback

class PomodoroTimerViewModel(val builder: PomodoroTimerBuilder) : ViewModel(), PomodoroTimerCallback {

    val pomodoroLength = 25 * 60 * 1000L
    val counterInterval = 500L

    val timerText = ObservableLong(pomodoroLength)
    val isTimerRunning = ObservableBoolean()

    private val timer by lazy { builder.create(pomodoroLength, counterInterval, this) }

    fun handleTimerButtonClicked() {
        if (isTimerRunning.get()) {
            isTimerRunning.set(false)
            timer.cancel()
        } else {
            isTimerRunning.set(true)
            timer.start()
        }
    }

    override fun timerTickCallback(millisUntilFinished: Long) {
        timerText.set(millisUntilFinished)
    }

    override fun timerFinishedCallback() {
        isTimerRunning.set(false)
    }
}