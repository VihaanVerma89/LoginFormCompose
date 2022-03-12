package academy.compose.settings.ui

import academy.compose.settings.R
import academy.compose.settings.SettingsViewModel
import academy.compose.settings.model.SettingsState
import academy.compose.settings.ui.theme.LoginFormComposeTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun Settings() {
    val viewModel: SettingsViewModel = viewModel()

    LoginFormComposeTheme {
        val state = viewModel.uiState.collectAsState().value
        SettingsList(
            state = state,
            toggleNotificationSetting = viewModel::toggleNotificationSetting
        )
    }
}

@Composable
fun SettingsList(
    state: SettingsState,
    toggleNotificationSetting: () -> Unit,
) {
    Column {
        TopAppBar(
            backgroundColor = MaterialTheme.colors.surface
        ) {
            Icon(
                tint = MaterialTheme.colors.onSurface,
                imageVector = Icons.Default.ArrowBack,
                contentDescription = null
            )
            Spacer(modifier = Modifier.width(16.dp))
            Text(
                color = MaterialTheme.colors.onSurface,
                text = stringResource(id = R.string.title_settings),
                fontSize = 18.sp
            )
        }

        NotificationSettings(
            modifier = Modifier.fillMaxWidth(),
            title = stringResource(id = R.string.notification_settings),
            checked = state.notificationEnabled
        ) {
            toggleNotificationSetting()
        }
        Divider()
    }
}

@Preview
@Composable
fun PreviewSettings() {
    LoginFormComposeTheme {
        Settings()
    }
}