package com.github.dlweatherhead.pomodorotimer

import android.os.CountDownTimer
import com.github.dlweatherhead.pomodorotimer.utility.timer.PomodoroTimerBuilder
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
        viewModel.handleTimerButtonClicked()

        verify(mockPomodoroTimerBuilder).create(25 * 60 * 1000L, 500L, viewModel)
    }

    @Test
    fun testHandleTimerButtonClickedIsTimerRunningFalseInvokesStartOnTimer() {
        viewModel.isTimerRunning.set(false)

        viewModel.handleTimerButtonClicked()

        verify(mockPomodoroTimer).start()
    }

    @Test
    fun testHandleTimerBurronClickedIsTimerRunningTrueInvokesCancelOnTimer() {
        viewModel.isTimerRunning.set(true)

        viewModel.handleTimerButtonClicked()

        verify(mockPomodoroTimer).cancel()
    }

    @Test
    fun testTimerTickCallbackSetsTimerText() {
        viewModel.timerTickCallback(1000)

        assertEquals(1000, viewModel.timerText.get())
    }

    @Test
    fun testTimerFinishedCallbackSetIsTimerRunningFalse() {
        viewModel.isTimerRunning.set(true)

        viewModel.timerFinishedCallback()

        assertEquals(false, viewModel.isTimerRunning.get())
    }

    @Test
    fun testHandleTimerButtonClickedSetIsTimerRunningTrue() {
        viewModel.isTimerRunning.set(false)

        viewModel.handleTimerButtonClicked()

        assertEquals(true, viewModel.isTimerRunning.get())
    }

    @Test
    fun testTimerFinishCallbackSetIsTimerRunningFalse() {
        viewModel.isTimerRunning.set(true)

        viewModel.timerFinishedCallback()

        assertEquals(false, viewModel.isTimerRunning.get())
    }
}