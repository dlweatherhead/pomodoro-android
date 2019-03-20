package com.github.dlweatherhead.pomodorotimer.view

import android.arch.lifecycle.ViewModel
import android.databinding.ObservableBoolean
import android.databinding.ObservableLong
import com.github.dlweatherhead.pomodorotimer.utility.timer.PomodoroTimerBuilder
import com.github.dlweatherhead.pomodorotimer.utility.timer.PomodoroTimerCallback

class PomodoroTimerViewModel(val builder: PomodoroTimerBuilder) : ViewModel(),
    PomodoroTimerCallback {

    private val timerLength = 25 * 60 * 1000L
    private val timerInterval = 500L

    val timerText = ObservableLong(timerLength)
    val isTimerRunning = ObservableBoolean()
    val showToastTrigger = ObservableBoolean()

    private val timer by lazy { builder.create(timerLength, timerInterval, this) }

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
        showToastTrigger.set(!showToastTrigger.get())
        isTimerRunning.set(false)
    }
}