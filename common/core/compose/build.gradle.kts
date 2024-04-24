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
                implementation(compose.components.resources)
            }
        }
        iosMain {
            dependencies {
                implementation(compose.runtime)
                implementation(compose.material)
                implementation(compose.foundation)
                implementation(compose.ui)
            }
        } 
    }
}

android {
    namespace = "ru.aaprokin.store.core.compose"
}
