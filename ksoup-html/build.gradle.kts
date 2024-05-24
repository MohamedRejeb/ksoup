import org.jetbrains.kotlin.gradle.targets.js.nodejs.NodeJsRootExtension
import org.jetbrains.kotlin.gradle.targets.js.npm.tasks.KotlinNpmInstallTask

plugins {
    alias(libs.plugins.multiplatform)
    id("module.publication")
}

kotlin {
    applyDefaultHierarchyTemplate()
    explicitApi()
    jvmToolchain(8)

    androidNativeArm32()
    androidNativeArm64()
    androidNativeX86()
    androidNativeX64()
    jvm()
    js(IR).nodejs()
    iosX64()
    iosArm64()
    iosSimulatorArm64()
    tvosX64()
    tvosArm64()
    tvosSimulatorArm64()
    watchosX64()
    watchosArm32()
    watchosArm64()
    watchosDeviceArm64()
    watchosSimulatorArm64()
    linuxX64()
    linuxArm64()
    macosX64()
    macosArm64()
    mingwX64()
    @OptIn(org.jetbrains.kotlin.gradle.targets.js.dsl.ExperimentalWasmDsl::class)
    wasmJs().nodejs()
    @OptIn(org.jetbrains.kotlin.gradle.targets.js.dsl.ExperimentalWasmDsl::class)
    wasmWasi().nodejs()

    sourceSets {
        /* Main source sets */
        val commonMain by getting {
            dependencies {
                implementation(project(":ksoup-entities"))
                // The library is lightweight, we don't use any other dependencies :D
            }
        }

        /* Test source sets */
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
    }
}
