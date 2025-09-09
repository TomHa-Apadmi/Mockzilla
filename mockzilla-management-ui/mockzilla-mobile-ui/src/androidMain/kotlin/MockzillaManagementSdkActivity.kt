package com.apadmi.mockzilla

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.CompositionLocalProvider
import com.apadmi.mockzilla.mobile.ui.MobileAppRoot
import com.apadmi.mockzilla.mobile.ui.startMockzillaMobileUiKoin
import org.koin.core.context.stopKoin

class MockzillaManagementSdkActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        startMockzillaMobileUiKoin()

        setContent {
            CompositionLocalProvider {
                MobileAppRoot(onClose = { finish() })
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        stopKoin()
    }
}
