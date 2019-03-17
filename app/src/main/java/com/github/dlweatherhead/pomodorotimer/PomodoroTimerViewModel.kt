package com.github.dlweatherhead.pomodorotimer

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.databinding.ObservableField
import android.os.CountDownTimer
import java.util.concurrent.TimeUnit

class PomodoroTimerViewModel(app: Application) : AndroidViewModel(app) {

    val pomodoroLength = 25 * 60 * 1000L
    val counterInterval = 500L

    val timerText = ObservableField<String>(convertToTimeDisplay(pomodoroLength))

    private val countdownTimer = object : CountDownTimer(pomodoroLength, counterInterval) {
        override fun onFinish() {
            timerText.set("Take a break!")
        }

        override fun onTick(millisUntilFinished: Long) {
            timerText.set(convertToTimeDisplay(millisUntilFinished))
        }
    }

    fun startTimer() {
        countdownTimer.start()
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