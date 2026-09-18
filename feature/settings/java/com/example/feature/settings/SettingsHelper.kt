package com.example.feature.settings

import com.example.core.utils.StringUtils

class SettingsHelper {

    fun applySettings(username: String, isDarkTheme: Boolean): String {
        val sanitized = if (StringUtils.isNullOrEmpty(username)) {
            "User"
        } else {
            StringUtils.capitalize(username)
        }
        // In a real app, save to DataStore or SharedPreferences
        return "name=$sanitized, dark=$isDarkTheme"
    }

    fun isValidUsername(username: String): Boolean {
        return !StringUtils.isNullOrEmpty(username) && username.length >= 2
    }
}
