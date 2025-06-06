/*
 * Copyright 2021 IceRock MAG Inc. Use of this source code is governed by the Apache 2.0 license.
 */

package dev.icerock.moko.graphics

/**
 * Parses a hexadecimal color string into a [Color] object.
 *
 * This function supports multiple hex color formats with optional hash prefix:
 * - **3 digits (RGB)**: Each digit is expanded to two digits (e.g., "F0A" → "FF00AA")
 * - **4 digits (ARGB)**: Each digit is expanded to two digits (e.g., "8F0A" → "88FF00AA")
 * - **6 digits (RRGGBB)**: Standard RGB format with full alpha (255)
 * - **8 digits (AARRGGBB)**: Full ARGB format with explicit alpha channel
 *
 * The hash prefix (#) is optional and will be automatically removed if present.
 * All input is converted to uppercase for consistent parsing.
 *
 * @param colorHEX
 * The hexadecimal color string to parse. Can include optional '#' prefix.
 * Supports formats: RGB, ARGB, RRGGBB, AARRGGBB (case-insensitive).
 *
 * @return A [Color] object with ARGB values in the range 0-255.
 *
 * @throws IllegalArgumentException
 * if the input string is not a valid hex color format or contains invalid hexadecimal characters.
 *
 */
@Suppress("MagicNumber")
public fun Color.Companion.parseColor(colorHEX: String): Color {
    val clean = colorHEX.removePrefix("#").uppercase()

    return when (clean.length) {
        3 -> {
            // RGB -> RRGGBB
            val r = clean[0].digitToInt(16) * 17
            val g = clean[1].digitToInt(16) * 17
            val b = clean[2].digitToInt(16) * 17
            Color(red = r, green = g, blue = b, alpha = 255)
        }

        4 -> {
            // ARGB
            val a = clean[0].digitToInt(radix = 16) * 17
            val r = clean[1].digitToInt(16) * 17
            val g = clean[2].digitToInt(16) * 17
            val b = clean[3].digitToInt(16) * 17
            Color(alpha = a, red = r, green = g, blue = b)
        }

        6 -> {
            // RRGGBB
            val r = clean.substring(0, 2).toInt(16)
            val g = clean.substring(2, 4).toInt(16)
            val b = clean.substring(4, 6).toInt(16)
            Color(red = r, green = g, blue = b, alpha = 255)
        }

        8 -> {
            // AARRGGBB
            val a = clean.substring(0, 2).toInt(16)
            val r = clean.substring(2, 4).toInt(16)
            val g = clean.substring(4, 6).toInt(16)
            val b = clean.substring(6, 8).toInt(16)
            Color(alpha = a, red = r, green = g, blue = b)
        }

        else -> throw IllegalArgumentException("Invalid Hex color: $colorHEX")
    }
}
