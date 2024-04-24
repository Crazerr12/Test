enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")
pluginManagement {
    includeBuild("buildLogic")
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
    }
}

dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "Store"
include(":androidApp")
//include(":shared")

include(":common:core:storage")
include(":common:core:network")
include(":common:core:compose")
include(":common:core:mediator")
include(":common:core:utils")

include(":common:umbrella:android")
include(":common:umbrella:ios")

include(":common:feature:auth:data")
include(":common:feature:auth:domain")
include(":common:feature:auth:presentation")
