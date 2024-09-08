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
    }
}

allprojects {
    plugins.withId("org.gradle.maven-publish") {
        group = "dev.icerock.moko"
        version = libs.versions.mokoGraphicsVersion.get()
    }
    tasks.withType<KotlinCompile> {
        compilerOptions.jvmTarget = JvmTarget.JVM_1_8
    }

    // fix Reason: Task ':graphics:publishJsPublicationToOSSRHRepository' uses this output of task ':graphics:signAndroidDebugPublication' without declaring an explicit or implicit dependency. This can lead to incorrect results being produced, depending on what order the tasks are executed.
    val signingTasks = tasks.withType<Sign>()
    tasks.withType<AbstractPublishToMaven>().configureEach {
        dependsOn(signingTasks)
    }
}
