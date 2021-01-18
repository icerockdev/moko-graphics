/*
 * Copyright 2019 IceRock MAG Inc. Use of this source code is governed by the Apache 2.0 license.
 */

plugins {
    plugin(Deps.Plugins.androidLibrary)
    plugin(Deps.Plugins.kotlinMultiPlatform)
    plugin(Deps.Plugins.mobileMultiPlatform)
    plugin(Deps.Plugins.mavenPublish)
}

group = "dev.icerock.moko"
version = Deps.mokoGraphicsVersion

dependencies {
    androidMainImplementation(Deps.Libs.Android.annotation)
}

kotlin {
    macosX64()
    tvos()
    watchos()
    jvm()
    js {
        nodejs()
        browser()
    }
    linux()
    windows()
    wasm32()
}

fun org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension.linux() {
    linuxArm64()
    linuxArm32Hfp()
    linuxMips32()
    linuxMipsel32()
    linuxX64()
}

fun org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension.windows() {
    mingwX64()
    mingwX86()
}

publishing {
    repositories.maven("https://api.bintray.com/maven/icerockdev/moko/moko-graphics/;publish=1") {
        name = "bintray"

        credentials {
            username = System.getProperty("BINTRAY_USER")
            password = System.getProperty("BINTRAY_KEY")
        }
    }

    // Make sure to avoid duplicate publications
    val publicationsFromMainHost = listOf(
            "wasm32",
            "jvm",
            "js",
            "kotlinMultiplatform",
            "androidRelease",
            "androidDebug",
            "linuxArm64",
            "linuxArm32Hfp",
            "linuxX64"
    )

    publications
            .matching { it.name in publicationsFromMainHost }
            .all {
                val targetPublication = this@all
                tasks.withType<AbstractPublishToMaven>()
                        .matching { it.publication == targetPublication }
                        .all { onlyIf { System.getProperty("IS_MAIN_HOST") == "true" } }
            }
}
