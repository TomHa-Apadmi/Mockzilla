require "apadmi_grout"

platform :android do 

    lane :management_ui_pull_request do
        gradle(
            tasks: [
                ":mockzilla-management-ui:mockzilla-desktop:assembleDebug",
                ":mockzilla-management-ui:mockzilla-desktop:desktopTest",
                ":mockzilla-management-ui:mockzilla-management-ui-common:desktopTest",
                ":mockzilla-management-ui:mockzilla-mobile-ui:testDebugUnitTest"
            ]
        )
    end
end
