package com.pipeanayap.animalsapp.utils

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

public val Tree: ImageVector
    get() {
        if (_tree != null) {
            return _tree!!
        }
        _tree = ImageVector.Builder(
            name = "Tree",
            defaultWidth = 16.dp,
            defaultHeight = 16.dp,
            viewportWidth = 16f,
            viewportHeight = 16f
        ).apply {
            path(
                fill = SolidColor(Color(0xFF000000)),
                fillAlpha = 1.0f,
                stroke = null,
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                // (se mantiene el path original sin cambios)
                moveTo(8.416f, 0.223f)
                arcToRelative(0.5f, 0.5f, 0f, false, false, -0.832f, 0f)
                lineToRelative(-3f, 4.5f)
                arcTo(0.5f, 0.5f, 0f, false, false, 5f, 5.5f)
                horizontalLineToRelative(0.098f)
                lineTo(3.076f, 8.735f)
                arcTo(0.5f, 0.5f, 0f, false, false, 3.5f, 9.5f)
                horizontalLineToRelative(0.191f)
                lineToRelative(-1.638f, 3.276f)
                arcToRelative(0.5f, 0.5f, 0f, false, false, 0.447f, 0.724f)
                horizontalLineTo(7f)
                verticalLineTo(16f)
                horizontalLineToRelative(2f)
                verticalLineToRelative(-2.5f)
                horizontalLineToRelative(4.5f)
                arcToRelative(0.5f, 0.5f, 0f, false, false, 0.447f, -0.724f)
                lineTo(12.31f, 9.5f)
                horizontalLineToRelative(0.191f)
                arcToRelative(0.5f, 0.5f, 0f, false, false, 0.424f, -0.765f)
                lineTo(10.902f, 5.5f)
                horizontalLineTo(11f)
                arcToRelative(0.5f, 0.5f, 0f, false, false, 0.416f, -0.777f)
                close()
                moveTo(6.437f, 4.758f)
                arcTo(0.5f, 0.5f, 0f, false, false, 6f, 4.5f)
                horizontalLineToRelative(-0.066f)
                lineTo(8f, 1.401f)
                lineTo(10.066f, 4.5f)
                horizontalLineTo(10f)
                arcToRelative(0.5f, 0.5f, 0f, false, false, -0.424f, 0.765f)
                lineTo(11.598f, 8.5f)
                horizontalLineTo(11.5f)
                arcToRelative(0.5f, 0.5f, 0f, false, false, -0.447f, 0.724f)
                lineTo(12.69f, 12.5f)
                horizontalLineTo(3.309f)
                lineToRelative(1.638f, -3.276f)
                arcTo(0.5f, 0.5f, 0f, false, false, 4.5f, 8.5f)
                horizontalLineToRelative(-0.098f)
                lineToRelative(2.022f, -3.235f)
                arcToRelative(0.5f, 0.5f, 0f, false, false, 0.013f, -0.507f)
            }
        }.build()
        return _tree!!
    }

private var _tree: ImageVector? = null


public val Lion: ImageVector
    get() {
        if (_lion != null) {
            return _lion!!
        }
        _lion = ImageVector.Builder(
            name = "Lion",
            defaultWidth = 24.dp,
            defaultHeight = 24.dp,
            viewportWidth = 24f,
            viewportHeight = 24f
        ).apply {
            path(
                fill = SolidColor(Color(0xFF000000)),
                stroke = SolidColor(Color(0xFF000000)),
                strokeLineWidth = 2f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(13f, 4f)
                arcTo(2f, 2f, 0f, false, true, 11f, 6f)
                arcTo(2f, 2f, 0f, false, true, 9f, 4f)
                arcTo(2f, 2f, 0f, false, true, 13f, 4f)
                close()
            }
            path(
                fill = null,
                stroke = SolidColor(Color(0xFF000000)),
                strokeLineWidth = 2f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(20f, 8f)
                arcTo(2f, 2f, 0f, false, true, 18f, 10f)
                arcTo(2f, 2f, 0f, false, true, 16f, 8f)
                arcTo(2f, 2f, 0f, false, true, 20f, 8f)
                close()
            }
            path(
                fill = null,
                stroke = SolidColor(Color(0xFF000000)),
                strokeLineWidth = 2f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(22f, 16f)
                arcTo(2f, 2f, 0f, false, true, 20f, 18f)
                arcTo(2f, 2f, 0f, false, true, 18f, 16f)
                arcTo(2f, 2f, 0f, false, true, 22f, 16f)
                close()
            }
            path(
                fill = null,
                stroke = SolidColor(Color(0xFF000000)),
                strokeLineWidth = 2f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(9f, 10f)
                arcToRelative(5f, 5f, 0f, false, true, 5f, 5f)
                verticalLineToRelative(3.5f)
                arcToRelative(3.5f, 3.5f, 0f, false, true, -6.84f, 1.045f)
                quadTo(6.52f, 17.48f, 4.46f, 16.84f)
                arcTo(3.5f, 3.5f, 0f, false, true, 5.5f, 10f)
                close()
            }
        }.build()
        return _lion!!
    }

private var _lion: ImageVector? = null

