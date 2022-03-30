package com.alireza.bashi.learn.jetpack.compose.utility

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Path
import kotlin.math.abs

fun Path.standardQuadFromTo(
    from: Offset,
    to: Offset
) {
    quadraticBezierTo(
        from.x,
        from.y,
        abs(from.x + to.x) /2,
        abs(from.y + to.y) /2,
    )
}