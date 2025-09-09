package com.apadmi.mockzilla.previews

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.apadmi.mockzilla.ui.ui.common.components.EmptyState
import com.apadmi.mockzilla.ui.ui.common.components.PreviewSurface

@Preview
@Composable
fun EmptyStatePreview() = PreviewSurface {
    Box(modifier = Modifier.size(200.dp)) {
        EmptyState(
            title = "Title",
            description = "Description text\non multiple lines",
        )
    }
}
