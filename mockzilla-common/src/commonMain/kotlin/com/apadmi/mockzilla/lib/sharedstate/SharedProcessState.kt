package com.apadmi.mockzilla.lib.sharedstate

import com.apadmi.mockzilla.lib.models.MockzillaRuntimeParams

// Used to share state between `mockzilla` and `mockzilla-management-ui` when
// running on the same device
object SharedProcessState {
    var runtimeParams: MockzillaRuntimeParams? = null
}
