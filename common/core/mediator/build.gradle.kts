plugins {
    id("store.multiplatform.compose")
}

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                implementation(compose.runtime)
                implementation(compose.material)
                implementation(compose.foundation)
                implementation(compose.ui)

//                implementation(project(":common:core:compose"))
//                implementation(project(":common:core:network"))
                implementation(project(":common:core:utils"))
                implementation(project(":common:feature:auth:presentation"))
            }
        }
    }
}

android {
    namespace = "ru.aaprokin.store.core.mediator"
}
