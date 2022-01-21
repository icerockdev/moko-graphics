package dev.icerock.moko.graphics

import platform.AppKit.NSColor

@Suppress("unused")
// Used in macOS targets
fun Color.toNSColor(): NSColor {
    val maxColorValue = 0xFF
    return NSColor.colorWithCalibratedRed(
        red = red.toDouble() / maxColorValue,
        green = green.toDouble() / maxColorValue,
        blue = blue.toDouble() / maxColorValue,
        alpha = alpha.toDouble() / maxColorValue
    )
}