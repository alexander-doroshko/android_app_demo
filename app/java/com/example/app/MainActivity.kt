package com.example.app

import android.content.Intent
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import com.example.feature.home.HomeScreen
import com.example.feature.profile.ProfileActivity
import com.example.feature.settings.SettingsActivity
import com.example.ui.theme.AppTheme

/**
 * Main entry point of the application.
 * Uses Jetpack Compose (setContent) to render HomeScreen.
 * Navigates to feature Activities using startActivity.
 */
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            AppTheme {
                HomeScreen(
                    onNavigateToProfile = {
                        startActivity(Intent(this, ProfileActivity::class.java))
                    },
                    onNavigateToSettings = {
                        startActivity(Intent(this, SettingsActivity::class.java))
                    },
                )
            }
        }
    }
}
