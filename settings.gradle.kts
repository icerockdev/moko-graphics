/*
 * Copyright 2019 IceRock MAG Inc. Use of this source code is governed by the Apache 2.0 license.
 */

enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

dependencyResolutionManagement {
    repositories {
        mavenCentral()
        google()
    }
}

rootProject.name = "moko-graphics"

includeBuild("graphics-build-logic")

include(":graphics")
include(":sample:android-app")
include(":sample:mpp-library")
