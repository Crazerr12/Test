import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension

class FeatureDataConventionPlugin : Plugin<Project> {

    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("store.multiplatform")
            }

            extensions.configure<KotlinMultiplatformExtension> {
                sourceSets.apply {
                    getByName("commonMain").apply {
                        dependencies {
                            implementation(project(":common:core:storage"))
                            implementation(project(":common:core:network"))
                            implementation(project(":common:core:utils"))
                        }
                    }
                }
            }
        }
    }
}
