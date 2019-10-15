/*
 * Copyright 2019 IceRock MAG Inc. Use of this source code is governed by the Apache 2.0 license.
 */

package com.icerockdev

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.icerockdev.library.GraphicsTest
import dev.icerock.moko.graphics.colorInt

class MainActivity : AppCompatActivity() {

    private val graphicsTest = GraphicsTest()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        val background: View = findViewById(R.id.background)

        background.setBackgroundColor(graphicsTest.backgroundColor.colorInt())
    }
}
