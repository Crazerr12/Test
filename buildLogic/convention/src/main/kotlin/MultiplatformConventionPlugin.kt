import com.android.build.gradle.LibraryExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension
import ru.aaprokin.store.utils.libs
import ru.aaprokin.store.utils.setupAndroid

class MultiplatformConventionPlugin : Plugin<Project> {

    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("com.android.library")
                apply("org.jetbrains.kotlin.multiplatform")
                apply("com.google.devtools.ksp")
                apply("kotlin-parcelize")
                apply("org.jetbrains.kotlin.plugin.serialization")
            }

            extensions.configure<LibraryExtension> {
                setupAndroid(this)
            }

            extensions.configure<KotlinMultiplatformExtension> {
                androidTarget()
                iosX64()
                iosArm64()
                iosSimulatorArm64()

                sourceSets.apply {
                    val commonMain = getByName("commonMain").apply {
                        dependencies {
                            implementation(libs.findLibrary("koin.core").get())
                            implementation(libs.findLibrary("decompose").get())
                            implementation(libs.findLibrary("decompose.jetbrains").get())
                            implementation(libs.findLibrary("kotlinx.coroutines.core").get())
                            implementation(libs.findLibrary("kotlinx.serialization.json").get())
                        }
                    }
                    val androidMain = getByName("androidMain").apply {
                        dependencies {
//                            implementation(libs.findLibrary("decompose.jetpack").get())
                            implementation(libs.findLibrary("kotlinx.coroutines.android").get())
                        }
                    }
                    val iosMain = create("iosMain")
                    val iosX64Main = getByName("iosX64Main")
                    val iosArm64Main = getByName("iosArm64Main")
                    val iosSimulatorArm64Main = getByName("iosSimulatorArm64Main")

                    androidMain.dependsOn(commonMain)
                    iosMain.dependsOn(commonMain)
                    iosX64Main.dependsOn(iosMain)
                    iosArm64Main.dependsOn(iosMain)
                    iosSimulatorArm64Main.dependsOn(iosMain)
                }
            }
        }
    }
}
