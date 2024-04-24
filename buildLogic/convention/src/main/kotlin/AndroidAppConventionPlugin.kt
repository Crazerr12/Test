import com.android.build.api.dsl.ApplicationExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies
import ru.aaprokin.store.utils.libs
import ru.aaprokin.store.utils.setupAndroid
import ru.aaprokin.store.utils.setupCompose

class AndroidAppConventionPlugin : Plugin<Project> {

    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("com.android.application")
                apply("org.jetbrains.kotlin.android")
            }
            extensions.configure<ApplicationExtension> {
                defaultConfig.apply {
                    applicationId = "ru.aaprokin.store"
                    targetSdk = 34
                }
                setupAndroid(this)
                setupCompose(this)
                buildTypes {
                    getByName("release") {
                        isMinifyEnabled = false
                    }
                }
            }
            dependencies {
                "implementation"(libs.findBundle("compose").get())
                "implementation"(libs.findLibrary("androidx.core.ktx").get())
                "implementation"(libs.findLibrary("androidx.core.splashscreen").get())
            }
        }
    }
}
