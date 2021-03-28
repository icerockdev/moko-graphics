/*
 * Copyright 2019 IceRock MAG Inc. Use of this source code is governed by the Apache 2.0 license.
 */

import java.util.Base64
import kotlin.text.String

plugins {
    plugin(Deps.Plugins.androidLibrary)
    plugin(Deps.Plugins.kotlinMultiPlatform)
    plugin(Deps.Plugins.mobileMultiPlatform)
    plugin(Deps.Plugins.mavenPublish)
    plugin(Deps.Plugins.signing)
}

group = "dev.icerock.moko"
version = Deps.mokoGraphicsVersion

dependencies {
    androidMainImplementation(Deps.Libs.Android.annotation)
}

kotlin {
    macosX64()
    tvos()
    watchos()
    jvm()
    js {
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
            name.set("MOKO parcelize")
            description.set("@Parcelize support for android from common code in Kotlin Multiplatform")
            url.set("https://github.com/icerockdev/moko-parcelize")
            licenses {
                license {
                    url.set("https://github.com/icerockdev/moko-parcelize/blob/master/LICENSE.md")
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
                connection.set("scm:git:ssh://github.com/icerockdev/moko-parcelize.git")
                developerConnection.set("scm:git:ssh://github.com/icerockdev/moko-parcelize.git")
                url.set("https://github.com/icerockdev/moko-parcelize")
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
