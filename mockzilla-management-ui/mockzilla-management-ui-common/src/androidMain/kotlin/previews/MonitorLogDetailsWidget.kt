package com.apadmi.mockzilla.previews

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

import com.apadmi.mockzilla.lib.internal.models.LogEvent
import com.apadmi.mockzilla.ui.ui.common.components.PreviewSurface
import com.apadmi.mockzilla.ui.ui.common.widgets.monitorlogs.details.LogDetailsContent
import com.apadmi.mockzilla.ui.ui.common.widgets.monitorlogs.details.MonitorLogDetailsEmptyContent
import com.apadmi.mockzilla.ui.ui.common.widgets.monitorlogs.details.MonitorLogDetailsViewModel

import io.ktor.http.HttpStatusCode

@Preview
@Composable
fun LogDetailsContentPreview() = PreviewSurface {
    LogDetailsContent(
        logDetail = LogEvent(
            timestamp = 1000,
            url = "https://www.example.com/url",
            requestBody = "request body",
            requestHeaders = mapOf(),
            responseHeaders = mapOf(),
            responseBody = "response body",
            status = HttpStatusCode.OK,
            delay = 50,
            method = "GET",
            isIntendedFailure = false,
        ),
        visible = MonitorLogDetailsViewModel.State.ViewDetails(
            requestHeaders = true,
            requestBody = true,
            responseHeaders = true,
            responseBody = true,
        ),
        onViewRequestHeaders = {},
        onViewRequestBody = {},
        onViewResponseHeaders = {},
        onViewResponseBody = {},
    )
}

@Preview
@Composable
fun MonitorLogDetailsEmptyContentPreview() = PreviewSurface {
    Box(modifier = Modifier.size(300.dp)) {
        MonitorLogDetailsEmptyContent()
    }
}
