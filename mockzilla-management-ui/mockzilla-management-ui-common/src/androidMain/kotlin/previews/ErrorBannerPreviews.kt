package com.apadmi.mockzilla.previews

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.apadmi.mockzilla.ui.ui.common.AppRootViewModel.State.Connected
import com.apadmi.mockzilla.ui.ui.common.components.ErrorBanner
import com.apadmi.mockzilla.ui.ui.common.components.PreviewSurface

@Preview
@Composable
fun ConnectionLostPreview() = PreviewSurface {
    ErrorBanner(
        state = Connected.ErrorBannerState.ConnectionLost,
        onRefreshAll = {},
        onDismissError = {},
    )
}

@Preview
@Composable
fun UnknownErrorPreview() = PreviewSurface {
    ErrorBanner(
        state = Connected.ErrorBannerState.UnknownError,
        onRefreshAll = {},
        onDismissError = {},
    )
}
