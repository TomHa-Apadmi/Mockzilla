package com.apadmi.mockzilla.previews

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

import com.apadmi.mockzilla.lib.models.MetaData
import com.apadmi.mockzilla.ui.ui.common.components.PreviewSurface
import com.apadmi.mockzilla.ui.ui.common.widgets.metadata.MetaDataListView

@Preview
@Composable
fun MetaDataListViewPreview() = PreviewSurface {
    MetaDataListView(
        metaData = MetaData(
            appName = "App name",
            appPackage = "app.package",
            operatingSystemVersion = "OS",
            deviceModel = "Model",
            appVersion = "App version",
            mockzillaVersion = "Mockzilla version"
        )
    )
}
