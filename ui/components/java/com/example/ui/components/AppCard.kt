package com.example.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ui.theme.AppTheme

@Composable
fun AppCard(
    title: String,
    subtitle: String,
    modifier: Modifier = Modifier,
    content: @Composable (() -> Unit)? = null,
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = title,
                style = MaterialTheme.typography.titleLarge,
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = subtitle,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
            )
            if (content != null) {
                Spacer(modifier = Modifier.height(12.dp))
                content()
            }
        }
    }
}

@Preview(name = "Card without content", showBackground = true)
@Composable
private fun AppCardPreview() {
    AppTheme {
        AppCard(
            title = "Welcome",
            subtitle = "This is a sample card component",
        )
    }
}

@Preview(name = "Card with content", showBackground = true)
@Composable
private fun AppCardWithContentPreview() {
    AppTheme {
        AppCard(
            title = "Alice Wonderland",
            subtitle = "alice@example.com",
        ) {
            AppPrimaryButton(text = "View Profile", onClick = {})
        }
    }
}
