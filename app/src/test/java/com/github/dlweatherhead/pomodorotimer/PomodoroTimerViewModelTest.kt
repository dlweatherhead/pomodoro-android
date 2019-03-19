package com.github.dlweatherhead.pomodorotimer

import android.os.CountDownTimer
import com.github.dlweatherhead.pomodorotimer.utility.PomodoroTimerBuilder
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations

class PomodoroTimerViewModelTest {

    @Mock
    private lateinit var mockPomodoroTimerBuilder: PomodoroTimerBuilder
    @Mock
    private lateinit var mockPomodoroTimer: CountDownTimer

    private lateinit var viewModel: PomodoroTimerViewModel

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        viewModel = PomodoroTimerViewModel(mockPomodoroTimerBuilder)

        `when`(
            mockPomodoroTimerBuilder.create(
                25 * 60 * 1000L,
                500L,
                viewModel
            )
        ).thenReturn(mockPomodoroTimer)
    }

    @Test
    fun testConstructionInvokesGetOnBuilder() {
        viewModel.startTimer()

        verify(mockPomodoroTimerBuilder).create(25 * 60 * 1000L, 500L, viewModel)
    }

    @Test
    fun testStartTimerInvokesStartOnTimer() {
        viewModel.startTimer()

        verify(mockPomodoroTimer).start()
    }

    @Test
    fun testTimerTickCallbackSetsTimerText() {
        viewModel.timerTickCallback(12 * 60 * 1000 + 35000)

        assertEquals("12:35", viewModel.timerText.get())
    }

    @Test
    fun testTimerFinishCallbackSetTimerText() {
        viewModel.timerFinishedCallback()

        assertEquals("Finished!", viewModel.timerText.get())
    }
}