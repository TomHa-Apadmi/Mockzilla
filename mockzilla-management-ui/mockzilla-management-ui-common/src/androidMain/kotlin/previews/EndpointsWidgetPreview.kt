package com.apadmi.mockzilla.previews

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

import com.apadmi.mockzilla.lib.models.EndpointConfiguration.Key
import com.apadmi.mockzilla.ui.ui.common.components.PreviewSurface
import com.apadmi.mockzilla.ui.ui.common.widgets.endpoints.endpoints.EndpointsViewModel
import com.apadmi.mockzilla.ui.ui.common.widgets.endpoints.endpoints.EndpointsWidgetContent

@Preview
@Composable
fun EndpointsWidgetContentPreview() = PreviewSurface {
    EndpointsWidgetContent(
        state = EndpointsViewModel.State.EndpointsList(
            endpoints = listOf(
                EndpointsViewModel.State.EndpointConfig(
                    key = Key("1"),
                    name = "FooBar",
                    fail = false,
                    isCheckboxTicked = false,
                    hasValuesOverridden = false,
                    display = true,
                ),
                EndpointsViewModel.State.EndpointConfig(
                    key = Key("2"),
                    name = "Foo",
                    fail = true,
                    isCheckboxTicked = true,
                    hasValuesOverridden = false,
                    display = true,
                ),
                EndpointsViewModel.State.EndpointConfig(
                    key = Key("3"),
                    name = "FooBuzz",
                    fail = false,
                    isCheckboxTicked = false,
                    hasValuesOverridden = true,
                    display = true,
                ),
                EndpointsViewModel.State.EndpointConfig(
                    key = Key("4"),
                    name = "Foobar",
                    fail = false,
                    isCheckboxTicked = false,
                    hasValuesOverridden = false,
                    display = true,
                ),
            ),
            filter = "Foo",
        ),
        onAllCheckboxChanged = {},
        onCheckboxChanged = { _, _ -> },
        onFailChanged = { _, _ -> },
        onFilterUpdate = {},
        onEndpointClicked = {},
    )
}
