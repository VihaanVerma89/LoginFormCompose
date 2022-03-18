package academy.compose.settings.ui

import academy.compose.settings.R
import academy.compose.settings.model.MarketingOption
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectable
import androidx.compose.material.RadioButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.unit.dp


@Composable
fun MarketingSettinItem(
    modifier: Modifier = Modifier,
    selectedOption: MarketingOption,
    onOptionSelected: (option: MarketingOption) -> Unit
) {
    SettingItem(modifier = modifier) {
        val options = stringArrayResource(id = R.array.setting_options_marketing_choice)

        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = stringResource(id = R.string.setting_option_marketing))
            Spacer(modifier = Modifier.height(8.dp))
            options.forEachIndexed { index, option ->
                Row(
                    modifier = Modifier
                        .padding(10.dp)
                        .fillMaxWidth()
                        .selectable(
                            selected = selectedOption.id == index,
                            onClick = {
                                val marketingOption = if (
                                    index == MarketingOption.ALLOWED.id
                                ) {
                                    MarketingOption.ALLOWED
                                } else MarketingOption.NOT_ALLOWED
                                onOptionSelected(marketingOption)
                            },
                            role = Role.RadioButton
                        ),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    RadioButton(selected = selectedOption.id == index, onClick = null)
                    Spacer(modifier = Modifier.width(10.dp))
                    Text(text = option)
                }
            }
        }
    }

}