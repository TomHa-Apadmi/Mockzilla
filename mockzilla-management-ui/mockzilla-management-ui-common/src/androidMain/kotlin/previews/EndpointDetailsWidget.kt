package com.apadmi.mockzilla.previews

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

import com.apadmi.mockzilla.lib.internal.models.SerializableEndpointConfig
import com.apadmi.mockzilla.lib.models.DashboardOptionsConfig
import com.apadmi.mockzilla.lib.models.EndpointConfiguration
import com.apadmi.mockzilla.ui.ui.common.components.PreviewSurface
import com.apadmi.mockzilla.ui.ui.common.widgets.endpoints.details.EndpointDetailsViewModel
import com.apadmi.mockzilla.ui.ui.common.widgets.endpoints.details.EndpointDetailsWidgetContent

@Preview
@Composable
fun EndpointDetailsWidgetContentPreview() = PreviewSurface {
    EndpointDetailsWidgetContent(
        state = EndpointDetailsViewModel.State.Endpoint(
            config = SerializableEndpointConfig.allNulls(
                key = EndpointConfiguration.Key("Foo"),
                name = "Foobar",
                versionCode = 1,
            ),
            defaultBody = null,
            defaultStatus = null,
            defaultHeaders = null,
            errorBody = null,
            errorStatus = null,
            errorHeaders = null,
            fail = null,
            delayMillis = null,
            jsonEditingDefault = false,
            jsonEditingError = false,
            presets = DashboardOptionsConfig(
                errorPresets = listOf(),
                successPresets = listOf(),
            )
        ),
        onDefaultBodyChange = {},
        onErrorBodyChange = {},
        onFailChange = {},
        onJsonDefaultEditingChange = {},
        onJsonErrorEditingChange = {},
        onDefaultStatusCodeChange = {},
        onErrorStatusCodeChange = {},
        onDelayChange = {},
        onDefaultHeadersChange = {},
        onErrorHeadersChange = {},
        onDefaultPresetSelected = {},
        onErrorPresetSelected = {},
        onResetAll = {},
    )
}
