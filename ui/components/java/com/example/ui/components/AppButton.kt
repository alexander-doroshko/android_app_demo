package com.example.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ui.theme.AppTheme

@Composable
fun AppPrimaryButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
) {
    Button(
        onClick = onClick,
        modifier = modifier
            .fillMaxWidth()
            .height(48.dp),
        enabled = enabled,
    ) {
        Text(text = text)
    }
}

@Composable
fun AppSecondaryButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
) {
    OutlinedButton(
        onClick = onClick,
        modifier = modifier
            .fillMaxWidth()
            .height(48.dp),
        enabled = enabled,
    ) {
        Text(text = text)
    }
}

@Preview(name = "Primary Button", showBackground = true)
@Composable
private fun AppPrimaryButtonPreview() {
    AppTheme {
        AppPrimaryButton(text = "Get Started", onClick = {})
    }
}

@Preview(name = "Secondary Button", showBackground = true)
@Composable
private fun AppSecondaryButtonPreview() {
    AppTheme {
        AppSecondaryButton(text = "Learn More", onClick = {})
    }
}

@Preview(name = "Disabled Button", showBackground = true)
@Composable
private fun AppPrimaryButtonDisabledPreview() {
    AppTheme {
        AppPrimaryButton(text = "Unavailable", onClick = {}, enabled = false)
    }
}
