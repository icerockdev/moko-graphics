/*
 * Copyright 2019 IceRock MAG Inc. Use of this source code is governed by the Apache 2.0 license.
 */

object Deps {
    private const val kotlinVersion = "1.4.21"

    private const val androidAppCompatVersion = "1.2.0"
    private const val androidAnnotationVersion = "1.1.0"

    const val mokoGraphicsVersion = "0.6.0"

    object Android {
        const val compileSdk = 28
        const val targetSdk = 28
        const val minSdk = 16
    }

    object Plugins {
        val androidLibrary = GradlePlugin(id = "com.android.library")
        val androidApplication = GradlePlugin(id = "com.android.application")
        val kotlinMultiPlatform = GradlePlugin(id = "org.jetbrains.kotlin.multiplatform")
        val kotlinAndroid = GradlePlugin(id = "kotlin-android")
        val mobileMultiPlatform = GradlePlugin(id = "dev.icerock.mobile.multiplatform")
        val appleFramework = GradlePlugin(id = "dev.icerock.mobile.multiplatform.apple-framework")
        val mavenPublish = GradlePlugin(id = "maven-publish")
    }

    object Libs {
        object Android {
            const val appCompat =
                "androidx.appcompat:appcompat:$androidAppCompatVersion"
            const val annotation =
                "androidx.annotation:annotation:$androidAnnotationVersion"
        }

        object MultiPlatform {
            val mokoGraphics = "dev.icerock.moko:graphics:$mokoGraphicsVersion"
                .defaultMPL(android = true, ios = true, macos = true)
        }
    }
}
