plugins {
    id("store.multiplatform.compose")
}

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                implementation(libs.kotlinx.serialization.json)
                implementation(libs.androidx.paging.common)
            }
        }
    }
}

android {
    namespace = "ru.aaprokin.store.core.utils"
}
