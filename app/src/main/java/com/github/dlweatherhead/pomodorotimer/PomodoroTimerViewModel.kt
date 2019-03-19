package com.github.dlweatherhead.pomodorotimer

import android.arch.lifecycle.ViewModel
import android.databinding.ObservableField
import com.github.dlweatherhead.pomodorotimer.utility.PomodoroTimerBuilder
import com.github.dlweatherhead.pomodorotimer.utility.PomodoroTimerCallback
import java.util.concurrent.TimeUnit

class PomodoroTimerViewModel(val builder: PomodoroTimerBuilder) : ViewModel(), PomodoroTimerCallback {

    val pomodoroLength = 25 * 60 * 1000L
    val counterInterval = 500L

    val timerText = ObservableField<String>(convertToTimeDisplay(pomodoroLength))

    fun startTimer() {
        builder.create(pomodoroLength, counterInterval, this).start()
    }

    override fun timerTickCallback(millisUntilFinished: Long) {
        timerText.set(convertToTimeDisplay(millisUntilFinished))
    }

    override fun timerFinishedCallback() {
        timerText.set("Finished!")
    }

    // TODO: Convert to utility
    private fun convertToTimeDisplay(milliseconds: Long): String {
        val minutes = TimeUnit.MILLISECONDS.toMinutes(milliseconds)
        val totalSeconds = TimeUnit.MILLISECONDS.toSeconds(milliseconds)
        val minuteSeconds = TimeUnit.MINUTES.toSeconds(minutes)

        // TODO: Extract format
        return String.format("%02d:%02d", minutes, totalSeconds - minuteSeconds)
    }
}