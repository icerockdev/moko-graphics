package com.icerockdev.library

import dev.icerock.moko.graphics.Color
import dev.icerock.moko.graphics.parseColor
import dev.icerock.moko.test.cases.TestCases
import kotlin.test.Test
import kotlin.test.assertEquals

class GraphicsTests : TestCases() {

    override val rules: List<Rule>
        get() = emptyList()

    @Test
    fun parseTest() {
        val colorRGB = Color.parseColor("#88AAFF")
        val colorFull = Color.parseColor("#FF88AAFF")
        val colorRGBShort = Color.parseColor("#8AF")
        val colorAlphaShort = Color.parseColor("#F8AF")
        val color2Full = Color.parseColor("#7788AAFF")
        val color2AlphaShort = Color.parseColor("#78AF")
        assertEquals(
            expected = colorRGB.argb,
            actual = 4287146751
        )
        assertEquals(
            expected = colorFull.argb,
            actual = 4287146751
        )
        assertEquals(
            expected = colorRGBShort.argb,
            actual = 4287146751
        )
        assertEquals(
            expected = colorAlphaShort.argb,
            actual = 4287146751
        )
        assertEquals(
            expected = color2AlphaShort.argb,
            actual = 2005445375
        )
        assertEquals(
            expected = color2Full.argb,
            actual = 2005445375
        )
    }
}