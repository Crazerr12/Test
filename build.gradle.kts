import io.gitlab.arturbosch.detekt.Detekt

plugins {
    //trick: for the same plugin versions in all sub-modules
    alias(libs.plugins.agp.application).apply(false)
    alias(libs.plugins.agp.library).apply(false)
    alias(libs.plugins.kotlin.android).apply(false)
    alias(libs.plugins.kotlin.multiplatform).apply(false)
    alias(libs.plugins.ksp).apply(false)
    alias(libs.plugins.serialization).apply(false)
    alias(libs.plugins.compose).apply(false)
    alias(libs.plugins.kotlinCocoapods).apply(false)
    //
    alias(libs.plugins.detekt).apply(true)
}

tasks.apply {
    register("clean", Delete::class) {
        @Suppress("DEPRECATION")
        delete(rootProject.buildDir)
    }
}


val detektCli: Provider<MinimalExternalModuleDependency> = libs.detekt.cli
val detektFormatting: Provider<MinimalExternalModuleDependency> = libs.detekt.formatting
val detektRulesLibraries: Provider<MinimalExternalModuleDependency> = libs.detekt.rules.libraries
val detektRulesRuleAuthors: Provider<MinimalExternalModuleDependency> = libs.detekt.rules.ruleauthors

allprojects {
    apply(plugin = "io.gitlab.arturbosch.detekt")
    detekt {
        source.setFrom(
            "src/main/java",
            "src/main/kotlin",
            "src/androidMain/kotlin",
            "src/commonMain/kotlin",
            "src/iosMain/kotlin",
            "src/desktopMain/kotlin",
            "src/jsMain/kotlin"
        )
        buildUponDefaultConfig = true
        parallel = true
        ignoreFailures = false
        baseline = file("$rootDir/config/detekt/baseline.xml")
        config.setFrom(
            file("$rootDir/config/detekt/detekt.yml")
        )
    }
    dependencies {
        detekt(detektCli)
        detektPlugins(detektFormatting)
        detektPlugins(detektRulesLibraries)
        detektPlugins(detektRulesRuleAuthors)
    }
    tasks.withType<Detekt>().configureEach {
        jvmTarget = "1.8"
        reports {
            html.required.set(true)
            xml.required.set(false)
            txt.required.set(false)
            sarif.required.set(false)
            md.required.set(false)
        }
        basePath = rootDir.absolutePath
    }
    tasks.withType<io.gitlab.arturbosch.detekt.DetektCreateBaselineTask>().configureEach {
        jvmTarget = "1.8"
    }
}

