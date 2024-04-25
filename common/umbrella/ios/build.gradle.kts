plugins {
    id("store.multiplatform")
    alias(libs.plugins.compose)
    kotlin("native.cocoapods")
}

// Pod version
version = "0.0.1"

@OptIn(org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi::class)
kotlin {
    @Suppress("DEPRECATION")
    targetHierarchy.default()

    androidTarget {
        compilations.all {
            kotlinOptions {
                jvmTarget = "1.8"
            }
        }
    }
    cocoapods {
        name = "shared"
        summary = "Store iOS SDK"
        homepage = "https://github.com/Alexandr-Prokin"
        license = "Free"
//        podfile = project.file("../iosApp/Podfile")
        ios.deploymentTarget = "16.0"

        framework {
            baseName = "StoreKit"
            export(libs.decompose)
            export(libs.essenty)
            export(project(":common:core:mediator"))
//            export(project(":common:core:network"))
            export(project(":common:core:storage"))
            export(project(":common:core:utils"))

            export(project(":common:feature:auth:presentation"))
        }
    }

    sourceSets {
        commonMain {
            dependencies {
                implementation(project(":common:core:mediator"))
//                implementation(project(":common:core:network"))
                implementation(project(":common:core:storage"))
                implementation(project(":common:core:utils"))

                implementation(project(":common:feature:auth:presentation"))
            }
        }
        iosMain {
            dependencies {
                api(project(":common:core:mediator"))
//                api(project(":common:core:network"))
                api(project(":common:core:storage"))
                api(project(":common:core:utils"))

                api(project(":common:feature:auth:presentation"))
                api(libs.decompose)
                api(libs.essenty)
                implementation(libs.decompose.jetbrains)
                implementation(compose.runtime)
                implementation(compose.ui)
                implementation(compose.foundation)
                implementation(compose.material)
            }
        }
    }
}

android {
    namespace = "ru.aaprokin.store.umbrella.ios"
}
