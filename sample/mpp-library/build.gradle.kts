/*
 * Copyright 2019 IceRock MAG Inc. Use of this source code is governed by the Apache 2.0 license.
 */

plugins {
    plugin(Deps.Plugins.androidLibrary)
    plugin(Deps.Plugins.kotlinMultiPlatform)
    plugin(Deps.Plugins.mobileMultiPlatform)
    plugin(Deps.Plugins.iosFramework)
}

kotlin {
    macosX64 {
        binaries {
            framework("MultiPlatformLibrary")
        }
    }
}

// temporary solution, until we fix https://github.com/icerockdev/mobile-multiplatform-gradle-plugin/issues/26
val cocoapodsDir = "${buildDir.absolutePath}/cocoapods/"
val cocoapodsPath = "$cocoapodsDir/framework"
kotlin.targets.withType<org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget>().matching {
    it.konanTarget == org.jetbrains.kotlin.konan.target.KonanTarget.MACOS_X64
}.all {
    binaries.withType<org.jetbrains.kotlin.gradle.plugin.mpp.Framework>().all {
        val syncTaskName = this.linkTaskName.replaceFirst("link", "copy")
        val frameworkPath = this.outputDirectory

        project.tasks.create(syncTaskName) {
            group = "cocoapods"

            doFirst {
                exec { commandLine("rm", "-rf", cocoapodsPath) }
                if (!File(cocoapodsDir).exists()) {
                    exec { commandLine("mkdir", cocoapodsDir) }
                }
                exec { commandLine("cp", "-R", frameworkPath, cocoapodsPath) }
            }

            dependsOn(linkTask)
        }
    }
}

tasks.matching { it.name.startsWith("sync") }.all {
    doFirst {
        exec { commandLine("rm", "-rf", cocoapodsPath) }
    }
}

dependencies {
    mppLibrary(Deps.Libs.MultiPlatform.mokoGraphics)
}

framework {
    export(Deps.Libs.MultiPlatform.mokoGraphics)
}
