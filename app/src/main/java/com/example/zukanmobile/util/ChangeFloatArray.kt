package com.example.zukanmobile.util

import androidx.compose.ui.graphics.Color
import kotlin.math.pow

fun Color.toSkyboxColor(): FloatArray {

    fun inverseGamma(v: Float): Float {
        return if (v <= 0.04045f) {
            v / 12.92f
        } else {
            ((v + 0.055f) / 1.055f).pow(2.4f)
        }
    }

    return floatArrayOf(
        inverseGamma(red),
        inverseGamma(green),
        inverseGamma(blue),
        alpha
    )
}