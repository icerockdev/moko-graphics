/*
 * Copyright 2020 IceRock MAG Inc. Use of this source code is governed by the Apache 2.0 license.
 */

subprojects {
    configurations.all {
        resolutionStrategy.dependencySubstitution {
            listOfNotNull(
                Deps.Libs.MultiPlatform.mokoGraphics.common,
                Deps.Libs.MultiPlatform.mokoGraphics.iosX64,
                Deps.Libs.MultiPlatform.mokoGraphics.iosArm64,
                Deps.Libs.MultiPlatform.mokoGraphics.macosX64
            ).forEach {
                substitute(module(it)).with(project(":graphics"))
            }
        }
    }
}
