package com.example.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

private val DarkColorScheme = darkColorScheme(
    primary = Purple80,
    secondary = PurpleGrey80,
    tertiary = Pink80,
)

private val LightColorScheme = lightColorScheme(
    primary = Purple40,
    secondary = PurpleGrey40,
    tertiary = Pink40,
)

@Composable
fun AppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit,
) {
    val colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme

    MaterialTheme(
        colorScheme = colorScheme,
        typography = AppTypography,
        content = content,
    )
}

@Preview(name = "Light Theme", showBackground = true)
@Composable
private fun AppThemeLightPreview() {
    AppTheme(darkTheme = false) {
        androidx.compose.material3.Surface {
            androidx.compose.material3.Text("App Theme — Light")
        }
    }
}

@Preview(name = "Dark Theme", showBackground = true)
@Composable
private fun AppThemeDarkPreview() {
    AppTheme(darkTheme = true) {
        androidx.compose.material3.Surface {
            androidx.compose.material3.Text("App Theme — Dark")
        }
    }
}
