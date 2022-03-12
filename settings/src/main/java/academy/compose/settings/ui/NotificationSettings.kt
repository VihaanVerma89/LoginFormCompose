package academy.compose.settings.ui

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.selection.toggleable
import androidx.compose.material.Switch
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.Role

@Composable
fun NotificationSettings(
    modifier: Modifier,
    title: String,
    checked: Boolean,
    onCheckedChanged: (checked: Boolean) -> Unit,
) {
    SettingItem(modifier = modifier) {
        Row(
            modifier = Modifier.toggleable(
                value = checked,
                onValueChange = onCheckedChanged,
                role = Role.Switch
            ),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                modifier = Modifier.weight(1f),
                text = title
            )
            Switch(checked = checked, onCheckedChange = null)
        }
    }
}