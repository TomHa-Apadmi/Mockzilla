import com.apadmi.mockzilla.AndroidConfig
import com.apadmi.mockzilla.JavaConfig
import com.apadmi.mockzilla.configureCommonProperties
import com.apadmi.mockzilla.injectedVersion
import com.apadmi.mockzilla.isSigningEnabled
import org.jetbrains.kotlin.gradle.plugin.mpp.apple.XCFramework

plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.android.library)
    alias(libs.plugins.compose)
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.spotless)
    alias(libs.plugins.ksp)
    alias(libs.plugins.kotlin.serialization)
    alias(libs.plugins.vanniktechPublish)
}

val artifactName = "mockzilla-mobile-ui"

kotlin {
    // Managed automatically by release-please PRs
    version = project.injectedVersion() ?: "0.0.1" // x-release-please-version

    androidTarget()
    jvmToolchain(JavaConfig.toolchain)

    val xcf = XCFramework()
    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = artifactName
            xcf.add(this)
        }
    }

    sourceSets {
        all {
            languageSettings.optIn("kotlin.time.ExperimentalTime")
        }
        commonMain.dependencies {
            /* Compose */
            implementation(compose.runtime)
            implementation(compose.material3)
            implementation(compose.components.resources)
            implementation(compose.materialIconsExtended)
            implementation(libs.navigation.compose)

            /* Localisable Strings */
            implementation(libs.lyricist.library)

            /* DI */
            implementation(libs.koin.core)

            /* Coroutines */
            implementation(libs.kotlinx.coroutines.core)

            /* JSON */
            implementation(libs.kotlinx.serialization.json)

            /* Mockzilla Management */
            implementation(project(":mockzilla-management-ui:mockzilla-management-ui-common"))
            implementation(project(":mockzilla-management"))
            implementation(project(":mockzilla-common"))

            /* Serialization */
            implementation(libs.kotlinx.serialization.json)

            /* Logging */
            implementation(libs.kermit)

            /* Version Handling */
            implementation(libs.semver)
        }
        commonTest.dependencies {
            implementation(kotlin("test"))
        }
        androidMain.dependencies {
            /* ViewModel */
            implementation(libs.androidx.lifecycleViewModelCompose)
            implementation(libs.koin.android)
            implementation(libs.koin.compose)

            implementation(libs.androidx.compose.activity)
            implementation(compose.preview)
            implementation(compose.components.uiToolingPreview)

            /* Mockzilla */
            // Android target is only used for development since it's a better dev experience than desktop
            // So using mockzilla to have a "Mock app" to connect to
            implementation(project(":mockzilla"))
            implementation(libs.ktor.client.core)
        }
        val androidUnitTest by getting {
            dependencies {
                implementation(libs.androidx.test.junit)
                implementation(libs.testParamInjector)
            }
        }
    }
}

android {
    namespace = "$group.mockzilla.mobile.ui"
    compileSdk = AndroidConfig.targetSdk
    defaultConfig {
        minSdk = AndroidConfig.minSdk
        targetSdk = AndroidConfig.targetSdk

        consumerProguardFiles("mockzilla-proguard-rules.pro")
    }

    compileOptions {
        sourceCompatibility = JavaConfig.version
        targetCompatibility = JavaConfig.version
    }
}

mavenPublishing {
    publishToMavenCentral(automaticRelease = true)

    if (isSigningEnabled()) {
        signAllPublications()
    }

    coordinates(group.toString(), artifactName, version.toString())

    pom {
        name.set("Mockzilla Mobile UI")
        description.set("User Interface for manipulating Mockzilla endpoint configs at runtime")

        configureCommonProperties()
    }
}
