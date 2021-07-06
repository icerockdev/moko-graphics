/*
 * Copyright 2019 IceRock MAG Inc. Use of this source code is governed by the Apache 2.0 license.
 */

plugins {
    id("android-app-convention")
    id("kotlin-android")
}

android {
    defaultConfig {
        applicationId = "dev.icerock.moko.samples.graphics"

        versionCode = 1
        versionName = "0.1.0"
    }
}

dependencies {
    implementation(libs.appCompat)

    implementation(projects.sample.mppLibrary)
}
