/*
 * Copyright 2019 IceRock MAG Inc. Use of this source code is governed by the Apache 2.0 license.
 */

import java.util.Base64
import kotlin.text.String

plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.multiplatform")
    id("dev.icerock.mobile.multiplatform")
    id("maven-publish")
    id("signing")
}

group = "dev.icerock.moko"
version = libs.versions.mokoGraphicsVersion.get()

dependencies {
    "androidMainImplementation"(libs.annotation)
}

kotlin {
    macosX64()
    tvos()
    watchos()
    jvm()
    js(BOTH) {
        nodejs()
        browser()
    }
    linux()
    windows()
    wasm32()
}

fun org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension.linux() {
    linuxArm64()
    linuxArm32Hfp()
    linuxMips32()
    linuxMipsel32()
    linuxX64()
}

fun org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension.windows() {
    mingwX64()
    mingwX86()
}

val javadocJar by tasks.registering(Jar::class) {
    archiveClassifier.set("javadoc")
}

publishing {
    repositories.maven("https://s01.oss.sonatype.org/service/local/staging/deploy/maven2/") {
        name = "OSSRH"

        credentials {
            username = System.getenv("OSSRH_USER")
            password = System.getenv("OSSRH_KEY")
        }
    }

    // Make sure to avoid duplicate publications
    val publicationsFromMainHost = listOf(
            "wasm32",
            "jvm",
            "js",
            "kotlinMultiplatform",
            "androidRelease",
            "androidDebug",
            "linuxArm64",
            "linuxArm32Hfp",
            "linuxX64"
    )

    publications
            .matching { it.name in publicationsFromMainHost }
            .all {
                val targetPublication = this@all
                tasks.withType<AbstractPublishToMaven>()
                        .matching { it.publication == targetPublication }
                        .all { onlyIf { System.getProperty("IS_MAIN_HOST") == "true" } }
            }

    publications.withType<MavenPublication> {
        // Stub javadoc.jar artifact
        artifact(javadocJar.get())

        // Provide artifacts information requited by Maven Central
        pom {
            name.set("MOKO graphics")
            description.set("Graphics primitives for mobile (android & ios) Kotlin Multiplatform development")
            url.set("https://github.com/icerockdev/moko-graphics")
            licenses {
                license {
                    url.set("https://github.com/icerockdev/moko-graphics/blob/master/LICENSE.md")
                }
            }

            developers {
                developer {
                    id.set("Alex009")
                    name.set("Aleksey Mikhailov")
                    email.set("aleksey.mikhailov@icerockdev.com")
                }
                developer {
                    id.set("nrobi144")
                    name.set("Nagy Robert")
                    email.set("nagyrobi144@gmail.com")
                }
            }

            scm {
                connection.set("scm:git:ssh://github.com/icerockdev/moko-graphics.git")
                developerConnection.set("scm:git:ssh://github.com/icerockdev/moko-graphics.git")
                url.set("https://github.com/icerockdev/moko-graphics")
            }
        }
    }

    signing {
        val signingKeyId: String? = System.getenv("SIGNING_KEY_ID")
        val signingPassword: String? = System.getenv("SIGNING_PASSWORD")
        val signingKey: String? = System.getenv("SIGNING_KEY")?.let { base64Key ->
            String(Base64.getDecoder().decode(base64Key))
        }
        if (signingKeyId != null) {
            useInMemoryPgpKeys(signingKeyId, signingKey, signingPassword)
            sign(publishing.publications)
        }
    }
}
