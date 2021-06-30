/*
 * Copyright 2021 IceRock MAG Inc. Use of this source code is governed by the Apache 2.0 license.
 */

package dev.icerock.moko.graphics

import java.lang.IllegalArgumentException

fun Color.Companion.parseColor(colorHEX: String): Color {
    if (colorHEX[0] != '#') throw IllegalArgumentException("Unknown color")
    var ARGB = colorHEX.substring(1).toLong(16)
    if (colorHEX.length == 7) {
        ARGB = ARGB or -0x1000000 // Java 0x00000000ff000000
    } else if (colorHEX.length != 9) {
        throw IllegalArgumentException("Unknown color")
    }
    return Color(
        alpha = (ARGB.shr(24) and 0xFF).toInt(),
        red = (ARGB.shr(16) and 0xFF).toInt(),
        green = (ARGB.shr(8) and 0xFF).toInt(),
        blue = (ARGB.shr(0) and 0xFF).toInt(),
    )
}
