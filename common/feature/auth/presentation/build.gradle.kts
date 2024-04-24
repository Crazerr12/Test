plugins {
    id("store.feature.presentation")
}

kotlin {
    sourceSets {
        commonMain {
            dependencies {
//                implementation(compose.runtime)
                implementation(compose.material)
                implementation(compose.foundation)
                implementation(compose.ui)
//                implementation(project(":common:feature:auth:data"))
//                implementation(project(":common:feature:auth:domain"))
            }
        }
    }
}

android {
    namespace = "ru.aaprokin.store.feature.auth.presentation"
}
