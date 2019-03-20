package com.github.dlweatherhead.pomodorotimer.utility.timer

import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations

class PomodoroTimerBuilderTest {

    @Mock
    private lateinit var mockCallback: PomodoroTimerCallback

    private val builder = PomodoroTimerBuilder()

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
    }

    @Test
    fun onCreateReturnsValidPomodoroTimer() {
        val result = builder.create(10L, 1L, mockCallback)

        assert(result is PomodoroTimer)
    }

}