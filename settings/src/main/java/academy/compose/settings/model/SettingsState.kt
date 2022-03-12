package academy.compose.settings.model

data class SettingsState(
    val notificationEnabled: Boolean = false,
    val hintsEnabled: Boolean = false,
    val marketingOption: MarketingOption = MarketingOption.ALLOWED,
    val selectedTheme: Theme = Theme.SYSTEM
)