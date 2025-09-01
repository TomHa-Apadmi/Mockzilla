package com.apadmi.mockzilla.previews

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

import com.apadmi.mockzilla.lib.internal.models.LogEvent
import com.apadmi.mockzilla.ui.ui.common.components.PreviewSurface
import com.apadmi.mockzilla.ui.ui.common.widgets.monitorlogs.MonitorLogsViewModel
import com.apadmi.mockzilla.ui.ui.common.widgets.monitorlogs.MonitorLogsWidgetContent

import io.ktor.http.HttpStatusCode

@Preview
@Composable
fun MonitorLogsWidgetContentPreview() = PreviewSurface {
    MonitorLogsWidgetContent(
        state = MonitorLogsViewModel.State.DisplayLogs(
            entries = sequenceOf(
                LogEvent(
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
                )
            ),
        ),
        onClearAll = {},
        onViewDetail = { _ -> },
    )
}
