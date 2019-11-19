/*
 * Copyright 2019 IceRock MAG Inc. Use of this source code is governed by the Apache 2.0 license.
 */

package dev.icerock.moko.graphics

import androidx.annotation.ColorInt

@ColorInt
fun Color.colorInt(): Int {
    return argb.toInt()
}
