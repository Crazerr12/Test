plugins {
    `kotlin-dsl`
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}
tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().configureEach {
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_17.toString()
    }
}

dependencies {
    compileOnly(libs.android.gradlePlugin)
    compileOnly(libs.kotlin.gradlePlugin)
    compileOnly(libs.ksp.gradlePlugin)
    compileOnly(libs.serialization.gradlePlugin)
    compileOnly(libs.compose.gradlePlugin)
}

gradlePlugin {
    plugins {
        register("androidApp") {
            id = "store.android.app"
            implementationClass = "AndroidAppConventionPlugin"
        }
        register("multiplatform") {
            id = "store.multiplatform"
            implementationClass = "MultiplatformConventionPlugin"
        }
        register("multiplatformCompose") {
            id = "store.multiplatform.compose"
            implementationClass = "MultiplatformComposeConventionPlugin"
        }
        register("featurePresentation") {
            id = "store.feature.presentation"
            implementationClass = "FeaturePresentationConventionPlugin"
        }
        register("featureDomain") {
            id = "store.feature.domain"
            implementationClass = "FeatureDomainConventionPlugin"
        }
        register("featureData") {
            id = "store.feature.data"
            implementationClass = "FeatureDataConventionPlugin"
        }
    }
}
