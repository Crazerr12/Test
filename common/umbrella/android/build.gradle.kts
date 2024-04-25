plugins {
    id("store.multiplatform")
}

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                api(libs.decompose)

                api(project(":common:core:mediator"))
                api(project(":common:core:utils"))

                implementation(project(":common:core:storage"))
//                implementation(project(":common:core:network"))
            }
        }

        androidMain {
            dependencies {
                api(libs.koin.core)
                api(libs.koin.android)
                api(libs.decompose.jetbrains)

                api(project(":common:core:utils"))
                api(project(":common:core:compose"))
            }
        }
    }
}

android {
    namespace = "ru.aaprokin.store.umbrella.android"
}
