package academy.compose.settings.ui

import academy.compose.settings.R
import academy.compose.settings.model.Theme
import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview


@Composable
fun ThemeSettingItem(
    modifier: Modifier = Modifier,
    selectedTheme: Theme,
    onThemeSelected: (theme: Theme) -> Unit
) {
    SettingItem(modifier = modifier) {
        var expanded by remember { mutableStateOf(false) }
        Row(
            modifier = Modifier.clickable {
                expanded = !expanded
            },
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                modifier = Modifier.weight(1f),
                text = stringResource(R.string.setting_option_theme)
            )
            Text(text = stringResource(selectedTheme.label))
        }

        DropdownMenu(expanded = expanded, onDismissRequest = {
            expanded = false
        }) {
            Theme.values().forEach { theme ->
                val label = stringResource(id = theme.label)
                DropdownMenuItem(
                    onClick = {
                        onThemeSelected(theme)
                        expanded = false
                    }) {
                    Text(text = label)
                }
            }
        }
    }
}

@Preview
@Composable
fun PreviewThemeSetting() {
    val current = LocalContext.current
    ThemeSettingItem(selectedTheme = Theme.LIGHT,
        onThemeSelected = {
            val stringResource = current.getString(it.label)
            Toast.makeText(current, "$stringResource", Toast.LENGTH_SHORT).show()
        })
}
