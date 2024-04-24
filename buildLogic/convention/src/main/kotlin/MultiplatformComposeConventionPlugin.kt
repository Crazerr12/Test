import com.android.build.gradle.LibraryExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension
import ru.aaprokin.store.utils.libs
import ru.aaprokin.store.utils.setupCompose

class MultiplatformComposeConventionPlugin : Plugin<Project> {

    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("store.multiplatform")
                apply("org.jetbrains.compose")
            }
            extensions.configure<LibraryExtension> {
                setupCompose(this)
            }
            extensions.configure<KotlinMultiplatformExtension> {
                sourceSets.maybeCreate("androidMain").dependencies {
                    implementation(libs.findLibrary("koin.compose").get())
//                    implementation(libs.findBundle("compose").get())
                }
                sourceSets.maybeCreate("commonMain").dependencies {
                    implementation(libs.findLibrary("koin.core").get())
//                    implementation(libs.findBundle("compose").get())
                }
            }
        }
    }
}
