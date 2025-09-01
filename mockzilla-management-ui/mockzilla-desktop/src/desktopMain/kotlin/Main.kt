@file:Suppress("PACKAGE_NAME_MISSING")

import androidx.compose.ui.Alignment
import androidx.compose.ui.window.*

import com.apadmi.mockzilla.desktop.engine.connection.AdbConnectorService
import com.apadmi.mockzilla.desktop.engine.connection.AdbConnectorServiceImpl
import com.apadmi.mockzilla.desktop.engine.connection.DeviceDetectionUseCase
import com.apadmi.mockzilla.desktop.engine.connection.DeviceDetectionUseCaseImpl
import com.apadmi.mockzilla.desktop.engine.connection.ZeroConfSdkWrapper
import com.apadmi.mockzilla.desktop.engine.connection.isLocalIpAddress
import com.apadmi.mockzilla.desktop.ui.DesktopApp
import com.apadmi.mockzilla.desktop.ui.deviceconnection.DeviceConnectionViewModel
import com.apadmi.mockzilla.desktop.ui.devicetabs.DeviceTabsViewModel
import com.apadmi.mockzilla.desktop.utils.rememberAppIcon
import com.apadmi.mockzilla.lib.config.ZeroConfConfig
import com.apadmi.mockzilla.ui.di.utils.MockzillaUiKoinContext
import com.apadmi.mockzilla.ui.di.utils.viewModel

import org.koin.dsl.module

import java.net.NetworkInterface

import kotlinx.coroutines.GlobalScope

fun main() = application {
    val state = rememberWindowState(
        placement = WindowPlacement.Maximized,
        position = WindowPosition(Alignment.Center),
        isMinimized = false
    )

    MockzillaUiKoinContext.startMockzillaUiKoinIfNeeded(module {
        single<AdbConnectorService> { AdbConnectorServiceImpl }
        single<DeviceDetectionUseCase> {
            DeviceDetectionUseCaseImpl(
                isLocalIpAddress = { address ->
                    NetworkInterface.getNetworkInterfaces().isLocalIpAddress(address)
                },
                adbConnectorService = get()
            ).also {
                get<ZeroConfSdkWrapper>().setListener(it::onChangedServiceEvent)
            }
        }
        single { ZeroConfSdkWrapper(ZeroConfConfig.serviceType + ".local.", GlobalScope) }
        viewModel { DeviceConnectionViewModel(get(), get(), get()) }
        viewModel { DeviceTabsViewModel(get(), get()) }
    })

    Window(
        title = "Mockzilla",
        resizable = true,
        state = state,
        icon = rememberAppIcon(),
        onCloseRequest = ::exitApplication,
        content = {
            DesktopApp()
        }
    )
}
