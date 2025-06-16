package com.icerockdev.library

import dev.icerock.moko.graphics.Color
import dev.icerock.moko.graphics.parseColor
import kotlin.test.Test
import kotlin.test.assertEquals

class GraphicsTests {

    @Test
    fun parseWithoutAlphaTest() {
        val colorRGB = Color.parseColor("#88AAFF")
        val colorFull = Color.parseColor("#FF88AAFF")
        val colorRGBShort = Color.parseColor("#8AF")
        val colorAlphaShort = Color.parseColor("#F8AF")
        assertEquals(
            expected = colorRGB.argb,
            actual = 0xFF88AAFF
        )
        assertEquals(
            expected = colorFull.argb,
            actual = 0xFF88AAFF
        )
        assertEquals(
            expected = colorRGBShort.argb,
            actual = 0xFF88AAFF
        )
        assertEquals(
            expected = colorAlphaShort.argb,
            actual = 0xFF88AAFF
        )
    }

    @Test
    fun parseWithAlphaTest() {
        val colorFull = Color.parseColor("#7788AAFF")
        val colorAlphaShort = Color.parseColor("#78AF")
        assertEquals(
            expected = colorAlphaShort.argb,
            actual = 0x7788AAFF
        )
        assertEquals(
            expected = colorFull.argb,
            actual = 0x7788AAFF
        )
    }

    @Test
    fun parseWithoutPrefixTest() {
        val colorRGB = Color.parseColor("88AAFF")
        val colorFull = Color.parseColor("FF88AAFF")
        val colorRGBShort = Color.parseColor("8AF")
        val colorAlphaShort = Color.parseColor("F8AF")
        assertEquals(
            expected = colorRGB.argb,
            actual = 0xFF88AAFF
        )
        assertEquals(
            expected = colorFull.argb,
            actual = 0xFF88AAFF
        )
        assertEquals(
            expected = colorRGBShort.argb,
            actual = 0xFF88AAFF
        )
        assertEquals(
            expected = colorAlphaShort.argb,
            actual = 0xFF88AAFF
        )
    }
}