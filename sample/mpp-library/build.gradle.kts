/*
 * Copyright 2019 IceRock MAG Inc. Use of this source code is governed by the Apache 2.0 license.
 */

plugins {
    plugin(Deps.Plugins.androidLibrary)
    plugin(Deps.Plugins.kotlinMultiPlatform)
    plugin(Deps.Plugins.mobileMultiPlatform)
    plugin(Deps.Plugins.appleFramework)
}

kotlin {
    macosX64()
}

dependencies {
    commonMainApi(Deps.Libs.MultiPlatform.mokoGraphics.common)
}

framework {
    export(Deps.Libs.MultiPlatform.mokoGraphics)
}
