package com.github.dlweatherhead.pomodorotimer.utility.timer

import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations

class PomodoroTimerTest {

    @Mock
    private lateinit var mockCallbacks: PomodoroTimerCallback

    private lateinit var pomodoroTimer: PomodoroTimer

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        pomodoroTimer = PomodoroTimer(10L, 1L, mockCallbacks)
    }

    @Test
    fun onTickInvokesTimerTickCallBack() {
        pomodoroTimer.onTick(500L)

        verify(mockCallbacks).timerTickCallback(500L)
    }

    @Test
    fun onFinishedInvokesTimerFinishedCallback() {
        pomodoroTimer.onFinish()

        verify(mockCallbacks).timerFinishedCallback()
    }

}