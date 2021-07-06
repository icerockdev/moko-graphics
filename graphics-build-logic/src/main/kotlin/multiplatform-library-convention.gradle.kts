/*
 * Copyright 2021 IceRock MAG Inc. Use of this source code is governed by the Apache 2.0 license.
 */

plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.multiplatform")
    id("android-base-convention")
    id("dev.icerock.mobile.multiplatform.android-manifest")
}

kotlin {
    ios()
    android {
        publishLibraryVariants("release", "debug")
    }
    macosX64()
    tvos()
    watchos()
    jvm()
    js(BOTH) {
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
