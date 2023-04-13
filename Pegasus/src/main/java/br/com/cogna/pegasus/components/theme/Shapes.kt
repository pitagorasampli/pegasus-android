package br.com.cogna.pegasus.components.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Shapes
import androidx.compose.ui.unit.dp

val shape = RoundedCornerShape(16.dp)

val pegasusShapes = Shapes(
    // Shapes None and Full are omitted as None is a RectangleShape and Full is a CircleShape.
    extraSmall = ShapeDefaults.ExtraSmall,
    small = ShapeDefaults.Small,
    medium = ShapeDefaults.Medium,
    large = ShapeDefaults.Large,
    extraLarge = ShapeDefaults.ExtraLarge,
)