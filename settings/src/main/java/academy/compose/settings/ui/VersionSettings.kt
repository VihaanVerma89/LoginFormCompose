package academy.compose.settings.ui

import academy.compose.settings.R
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun AppVersionSettingItem(
    modifier: Modifier = Modifier,
    appVersion: String
) {
    SettingItem(modifier = Modifier) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                modifier = Modifier.weight(1f), text = stringResource(id = R.string.app_version)
            )
            Text(text = appVersion)
        }
    }
}

@Preview
@Composable
fun PreviewAppVersionSettingItem() {
    MaterialTheme {
        AppVersionSettingItem(appVersion = "2.1.0")
    }

}