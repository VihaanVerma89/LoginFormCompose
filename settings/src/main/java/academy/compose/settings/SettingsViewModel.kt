package academy.compose.settings

import academy.compose.settings.model.SettingsState
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow

class SettingsViewModel : ViewModel() {

    val uiState = MutableStateFlow(SettingsState())

    fun toggleNotificationSetting(): Unit {
        uiState.value = uiState.value.copy(
            notificationEnabled = !uiState.value.notificationEnabled
        )
    }
}