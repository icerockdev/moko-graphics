package dev.icerock.moko.graphics

import platform.AppKit.NSColor

// Used in macOS targets
@Suppress("unused")
fun Color.toNSColor(): NSColor {
    @Suppress("MagicNumber")
    val maxColorValue = 0xFF
    return NSColor.colorWithCalibratedRed(
        red = red.toDouble() / maxColorValue,
        green = green.toDouble() / maxColorValue,
        blue = blue.toDouble() / maxColorValue,
        alpha = alpha.toDouble() / maxColorValue
    )
}
