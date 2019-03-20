package com.github.dlweatherhead.pomodorotimer.utility

import org.junit.Assert.assertEquals
import org.junit.Test

class TimeFormatUtilityTest {

    private val formatter = TimeFormatUtility()

    @Test
    fun testConvertToStandardTimeReturnsValidTimeString() {
        val timeInMilliseconds = 15 * 60 * 1000L + 23 * 1000L

        val result = formatter.convertToStandardTime(timeInMilliseconds)

        assertEquals("15:23", result)
    }
}