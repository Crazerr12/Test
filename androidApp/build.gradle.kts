plugins {
    id("store.android.app")
}

android {
    namespace = "ru.aaprokin.store.android"
    defaultConfig {
        versionCode = 1
        versionName = "0.0.1"
    }
    compileOptions {
        isCoreLibraryDesugaringEnabled = true
    }
}

dependencies {
    coreLibraryDesugaring(libs.desugaring)
    api(project(":common:umbrella:android"))
}
