package academy.compose.settings.ui

import androidx.compose.foundation.layout.heightIn
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun SettingItem(
    modifier: Modifier,
    content: @Composable () -> Unit,
) {
    Surface(modifier = modifier.heightIn(56.dp)) {
        content()
    }
}