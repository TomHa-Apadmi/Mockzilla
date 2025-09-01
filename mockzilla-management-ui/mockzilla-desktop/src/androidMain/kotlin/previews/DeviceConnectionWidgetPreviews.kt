package com.apadmi.mockzilla.previews

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.apadmi.mockzilla.desktop.ui.deviceconnection.DeviceConnectionContent
import com.apadmi.mockzilla.desktop.ui.deviceconnection.DeviceConnectionViewModel
import com.apadmi.mockzilla.ui.engine.connection.DetectedDevice
import com.apadmi.mockzilla.ui.ui.common.components.PreviewSurface

@Preview
@Composable
fun DeviceConnectionContentPreview() = PreviewSurface {
    Box(modifier = Modifier.padding(horizontal = 16.dp)) {
        DeviceConnectionContent(
            state = DeviceConnectionViewModel.State(
                ipAndPort = "127.0.0.1:60000",
                connectionState = DeviceConnectionViewModel.State.ConnectionState.Connecting,
                devices = listOf(
                    DetectedDevice(
                        connectionName = "iPhone",
                        metaData = null,
                        hostAddress = "127.0.0.1",
                        hostAddresses = listOf(),
                        port = 60000,
                        adbConnection = null,
                        state = DetectedDevice.State.ReadyToConnect,
                    )
                ),
            ),
            onIpAndPortChanged = {},
            onTapDevice = {},
        )
    }
}
