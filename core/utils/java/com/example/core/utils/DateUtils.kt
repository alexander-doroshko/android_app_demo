package com.example.core.utils

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

object DateUtils {

    private const val DISPLAY_FORMAT = "MMM dd, yyyy"
    private const val ISO_FORMAT = "yyyy-MM-dd'T'HH:mm:ss'Z'"

    fun formatForDisplay(date: Date): String {
        return SimpleDateFormat(DISPLAY_FORMAT, Locale.getDefault()).format(date)
    }

    fun formatIso(date: Date): String {
        return SimpleDateFormat(ISO_FORMAT, Locale.US).format(date)
    }

    fun isToday(date: Date): Boolean {
        val today = formatForDisplay(Date())
        val target = formatForDisplay(date)
        return today == target
    }
}
