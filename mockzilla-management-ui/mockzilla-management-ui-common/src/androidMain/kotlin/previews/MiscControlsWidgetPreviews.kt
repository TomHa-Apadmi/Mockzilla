package com.apadmi.mockzilla.previews

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.apadmi.mockzilla.ui.ui.common.components.PreviewSurface
import com.apadmi.mockzilla.ui.ui.common.widgets.misccontrols.MiscControlsWidgetContent

@Preview
@Composable
fun MiscControlsWidgetContentPreview() = PreviewSurface {
    MiscControlsWidgetContent(
        onRefreshAll = {},
        onClearAllOverrides = {},
    )
}
