/*
 * Copyright 2019 IceRock MAG Inc. Use of this source code is governed by the Apache 2.0 license.
 */

package dev.icerock.moko.graphics

import platform.UIKit.UIColor

fun Color.toUIColor(): UIColor {
    val maxColorValue: Int = 0xFF
    return UIColor(
        red = red.toDouble() / maxColorValue,
        green = green.toDouble() / maxColorValue,
        blue = blue.toDouble() / maxColorValue,
        alpha = alpha.toDouble() / maxColorValue
    )
}
