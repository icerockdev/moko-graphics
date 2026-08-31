import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

/*
 * Copyright 2019 IceRock MAG Inc. Use of this source code is governed by the Apache 2.0 license.
 */
buildscript {
    repositories {
        mavenCentral()
        google()
        gradlePluginPortal()
    }
    dependencies {
        classpath(":graphics-build-logic")
        classpath(libs.mokoGradlePlugin)
    }
}

apply(plugin = "dev.icerock.moko.gradle.publication.nexus")

group = "dev.icerock.moko"
version = libs.versions.mokoGraphicsVersion.get()

allprojects {
    group = "dev.icerock.moko"
    version = rootProject.version

    tasks.withType<KotlinCompile> {
        compilerOptions.jvmTarget = JvmTarget.JVM_1_8
    }

    // Ensure all publication tasks wait for generated signatures.
    val signingTasks = tasks.withType<Sign>()
    tasks.withType<AbstractPublishToMaven>().configureEach {
        dependsOn(signingTasks)
    }
}
