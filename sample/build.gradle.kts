/*
 * Copyright 2020 IceRock MAG Inc. Use of this source code is governed by the Apache 2.0 license.
 */

subprojects {

    configurations.all {
        resolutionStrategy.dependencySubstitution {
            listOfNotNull(
                libs.mokoGraphics.get().module
            ).forEach {
                substitute(module("${it.group}:${it.name}")).with(project(":graphics"))
            }
        }
    }
}
