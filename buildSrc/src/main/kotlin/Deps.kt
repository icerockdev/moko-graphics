/*
 * Copyright 2019 IceRock MAG Inc. Use of this source code is governed by the Apache 2.0 license.
 */

object Deps {
    object Plugins {
        val androidExtensions = GradlePlugin(
            id = "kotlin-android-extensions",
            module = "org.jetbrains.kotlin:kotlin-android-extensions:${Versions.Plugins.androidExtensions}"
        )
        val androidLibrary = GradlePlugin(id = "com.android.library")
        val androidApplication = GradlePlugin(id = "com.android.application")
        val kotlinMultiPlatform = GradlePlugin(id = "org.jetbrains.kotlin.multiplatform")
        val kotlinAndroid = GradlePlugin(id = "kotlin-android")
        val mobileMultiPlatform = GradlePlugin(id = "dev.icerock.mobile.multiplatform")
        val iosFramework = GradlePlugin(id = "dev.icerock.mobile.multiplatform.ios-framework")
        val mavenPublish = GradlePlugin(id = "maven-publish")
    }

    object Libs {
        object Android {
            val appCompat = AndroidLibrary(
                name = "androidx.appcompat:appcompat:${Versions.Libs.Android.appCompat}"
            )
            val annotation = AndroidLibrary(
                name = "androidx.annotation:annotation:${Versions.Libs.Android.annotation}"
            )
        }

        object MultiPlatform {
            val mokoGraphics = MultiPlatformLibrary(
                common = "dev.icerock.moko:graphics:${Versions.Libs.MultiPlatform.mokoGraphics}",
                iosX64 = "dev.icerock.moko:graphics-iosx64:${Versions.Libs.MultiPlatform.mokoGraphics}",
                iosArm64 = "dev.icerock.moko:graphics-iosarm64:${Versions.Libs.MultiPlatform.mokoGraphics}"
            )
        }
    }
}
