package com.example.feature.profile

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.domain.model.User
import com.example.ui.components.AppPrimaryButton
import com.example.ui.theme.AppTheme

/**
 * Composable section embedded inside ProfileActivity's ComposeView.
 * Demonstrates:
 *  - Using R.string.* from THIS module's resources
 *  - @Preview annotations for Compose Preview in Android Studio
 */
@Composable
fun ProfileDetails(
    user: User,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp),
    ) {
        Spacer(modifier = Modifier.height(8.dp))

        ProfileInfoRow(
            label = stringResource(R.string.profile_name_label),
            value = user.name,
        )

        HorizontalDivider(modifier = Modifier.padding(vertical = 8.dp))

        ProfileInfoRow(
            label = stringResource(R.string.profile_email_label),
            value = user.email,
        )

        HorizontalDivider(modifier = Modifier.padding(vertical = 8.dp))

        Text(
            text = stringResource(R.string.profile_rating_label),
            style = MaterialTheme.typography.labelMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
        )

        Spacer(modifier = Modifier.height(4.dp))

        // RatingBarView is used from //ui/widgets (Java custom View)
        // We embed it here via AndroidView
        androidx.compose.ui.viewinterop.AndroidView(
            factory = { context ->
                com.example.ui.widgets.RatingBarView(context).apply {
                    rating = 3.5f
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(40.dp),
        )

        Spacer(modifier = Modifier.height(24.dp))

        AppPrimaryButton(
            text = stringResource(R.string.profile_edit_button),
            onClick = { /* no-op in demo */ },
        )
    }
}

@Composable
private fun ProfileInfoRow(
    label: String,
    value: String,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            text = label,
            style = MaterialTheme.typography.labelMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            modifier = Modifier.weight(0.35f),
        )
        Text(
            text = value,
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.weight(0.65f),
        )
    }
}

@Preview(name = "Profile Details", showBackground = true)
@Composable
private fun ProfileDetailsPreview() {
    AppTheme {
        Surface {
            ProfileDetails(
                user = User(
                    id = "1",
                    name = "Alice",
                    email = "alice@example.com",
                ),
            )
        }
    }
}

@Preview(name = "Profile Details — Dark", showBackground = true)
@Composable
private fun ProfileDetailsDarkPreview() {
    AppTheme(darkTheme = true) {
        Surface {
            ProfileDetails(
                user = User(
                    id = "1",
                    name = "Alice",
                    email = "alice@example.com",
                ),
            )
        }
    }
}
