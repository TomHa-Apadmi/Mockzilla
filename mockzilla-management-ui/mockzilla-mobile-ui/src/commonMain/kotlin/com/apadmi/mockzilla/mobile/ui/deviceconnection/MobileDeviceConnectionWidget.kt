package com.apadmi.mockzilla.mobile.ui.deviceconnection

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.apadmi.mockzilla.mobile.ui.deviceconnection.MobileDeviceConnectionViewModel.*
import com.apadmi.mockzilla.ui.di.utils.getViewModel
import com.apadmi.mockzilla.ui.i18n.LocalStrings
import com.apadmi.mockzilla.ui.i18n.Strings

@Composable
internal fun MobileDeviceConnectionWidget(
    strings: Strings = LocalStrings.current
) {
    val viewModel = getViewModel<MobileDeviceConnectionViewModel>()
    val state by viewModel.state.collectAsState()

    return Column(Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center) {
        when (val currentState = state) {
            State.Connecting -> CircularProgressIndicator(Modifier.padding(end = 8.dp).size(20.dp))
            is State.Error -> {
                Text(strings.widgets.deviceConnection.errorTitle)
                Button(onClick = viewModel::attemptLocalConnection, contentPadding = PaddingValues(0.dp)) {
                    Text(
                        strings.widgets.errorBanner.refreshButton,
                        style = MaterialTheme.typography.bodySmall
                    )
                }
                Text(currentState.message)
            }
            State.Connected -> Text(strings.widgets.deviceConnection.connected)
        }
    }
}
