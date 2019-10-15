/*
 * Copyright 2019 IceRock MAG Inc. Use of this source code is governed by the Apache 2.0 license.
 */

package dev.icerock.moko.graphics

data class Color(
    val red: Int,
    val green: Int,
    val blue: Int,
    val alpha: Int
) {
    val rgba: Long = alpha.toLong() or
            blue.toLong().shl(8) or
            green.toLong().shl(16) or
            red.toLong().shl(24)

    val argb: Long = blue.toLong() or
            green.toLong().shl(8) or
            red.toLong().shl(16) or
            alpha.toLong().shl(24)
}
