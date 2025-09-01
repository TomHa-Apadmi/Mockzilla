package com.apadmi.mockzilla.mobile.ui

import com.apadmi.mockzilla.mobile.ui.deviceconnection.MobileDeviceConnectionViewModel
import com.apadmi.mockzilla.ui.di.utils.MockzillaUiKoinContext
import com.apadmi.mockzilla.ui.di.utils.viewModel

import org.koin.dsl.module

internal fun startMockzillaMobileUiKoin() {
    MockzillaUiKoinContext.startMockzillaUiKoinIfNeeded(module {
        viewModel { MobileDeviceConnectionViewModel(get(), get()) }
    })
}
