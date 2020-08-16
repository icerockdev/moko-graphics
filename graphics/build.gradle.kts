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
version = Versions.Libs.MultiPlatform.mokoGraphics

android {
    compileSdkVersion(Versions.Android.compileSdk)

    defaultConfig {
        minSdkVersion(Versions.Android.minSdk)
        targetSdkVersion(Versions.Android.targetSdk)
    }
}

dependencies {
    androidLibrary(Deps.Libs.Android.annotation)
}

publishing {
    repositories.maven("https://api.bintray.com/maven/icerockdev/moko/moko-graphics/;publish=1") {
        name = "bintray"

        credentials {
            username = System.getProperty("BINTRAY_USER")
            password = System.getProperty("BINTRAY_KEY")
        }
    }
}
