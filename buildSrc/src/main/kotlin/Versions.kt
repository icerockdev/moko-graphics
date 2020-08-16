/*
 * Copyright 2019 IceRock MAG Inc. Use of this source code is governed by the Apache 2.0 license.
 */

object Versions {
    object Android {
        const val compileSdk = 29
        const val targetSdk = 29
        const val minSdk = 16
    }

    const val kotlin = "1.4.0"

    object Plugins {
        const val kotlin = Versions.kotlin
        const val androidExtensions = Versions.kotlin
    }

    object Libs {
        object Android {
            const val appCompat = "1.2.0"
            const val annotation = "1.1.0"
        }

        object MultiPlatform {
            const val mokoGraphics: String = "0.4.0"
        }
    }
}