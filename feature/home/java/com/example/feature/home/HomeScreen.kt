package com.example.feature.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.domain.model.User
import com.example.ui.components.AppCard
import com.example.ui.components.AppPrimaryButton
import com.example.ui.components.AppSecondaryButton
import com.example.ui.theme.AppTheme

@Composable
fun HomeScreen(
    onNavigateToProfile: () -> Unit,
    onNavigateToSettings: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val homeViewModel = remember { HomeViewModel() }
    val user by homeViewModel.user.observeAsState()
    val isLoading by homeViewModel.isLoading.observeAsState(false)

    HomeContent(
        user = user,
        isLoading = isLoading,
        onNavigateToProfile = onNavigateToProfile,
        onNavigateToSettings = onNavigateToSettings,
        modifier = modifier,
    )
}

@Composable
internal fun HomeContent(
    user: User?,
    isLoading: Boolean,
    onNavigateToProfile: () -> Unit,
    onNavigateToSettings: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Surface(modifier = modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Spacer(modifier = Modifier.height(32.dp))

            Text(
                // Uses R.string.home_title from THIS module's own resources
                text = stringResource(R.string.home_title),
                style = MaterialTheme.typography.headlineMedium,
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = stringResource(R.string.home_subtitle),
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
            )

            Spacer(modifier = Modifier.height(24.dp))

            if (user != null) {
                AppCard(
                    title = stringResource(R.string.home_user_card_title),
                    subtitle = stringResource(R.string.home_greeting, user.name),
                ) {
                    Text(
                        text = user.email,
                        style = MaterialTheme.typography.bodyMedium,
                    )
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            AppPrimaryButton(
                text = stringResource(R.string.home_go_to_profile),
                onClick = onNavigateToProfile,
            )

            Spacer(modifier = Modifier.height(12.dp))

            AppSecondaryButton(
                text = stringResource(R.string.home_go_to_settings),
                onClick = onNavigateToSettings,
            )
        }
    }
}

@Preview(name = "Home Screen — with user", showBackground = true)
@Composable
private fun HomeScreenPreview() {
    AppTheme {
        HomeContent(
            user = User(id = "1", name = "Alice Wonderland", email = "alice@example.com"),
            isLoading = false,
            onNavigateToProfile = {},
            onNavigateToSettings = {},
        )
    }
}

@Preview(name = "Home Screen — loading", showBackground = true)
@Composable
private fun HomeScreenLoadingPreview() {
    AppTheme {
        HomeContent(
            user = null,
            isLoading = true,
            onNavigateToProfile = {},
            onNavigateToSettings = {},
        )
    }
}

@Preview(name = "Home Screen — Dark", showBackground = true)
@Composable
private fun HomeScreenDarkPreview() {
    AppTheme(darkTheme = true) {
        HomeContent(
            user = User(id = "1", name = "Alice Wonderland", email = "alice@example.com"),
            isLoading = false,
            onNavigateToProfile = {},
            onNavigateToSettings = {},
        )
    }
}
