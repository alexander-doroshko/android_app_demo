package com.example.core.utils

import org.junit.Assert.assertFalse
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertTrue
import org.junit.Test
import java.util.Date

class DateUtilsTest {

    @Test
    fun `formatForDisplay returns non-empty string`() {
        val result = DateUtils.formatForDisplay(Date())
        assertTrue(result.isNotBlank())
    }

    @Test
    fun `formatIso returns ISO formatted string`() {
        val result = DateUtils.formatIso(Date())
        assertTrue(result.contains("T"))
        assertTrue(result.endsWith("Z"))
    }

    @Test
    fun `isToday returns true for current date`() {
        assertTrue(DateUtils.isToday(Date()))
    }

    @Test
    fun `isToday returns false for old date`() {
        val oldDate = Date(0) // epoch
        assertFalse(DateUtils.isToday(oldDate))
    }
}
