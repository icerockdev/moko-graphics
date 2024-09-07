plugins {
    `kotlin-dsl`
}

repositories {
    mavenCentral()
    google()

    gradlePluginPortal()
}

dependencies {
    api("dev.icerock:mobile-multiplatform:0.14.2")
    api("org.jetbrains.kotlin:kotlin-gradle-plugin:2.0.0")
    api("com.android.tools.build:gradle:8.2.2")
    api("io.gitlab.arturbosch.detekt:detekt-gradle-plugin:1.23.6")
}
