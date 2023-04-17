package br.com.cogna.pegasus.components.button

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.LocalContentAlpha
import androidx.compose.material.LocalContentColor
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Refresh
import androidx.compose.material.icons.rounded.Save
import androidx.compose.material.icons.rounded.ShoppingCart
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.cogna.pegasus.components.theme.PegasusTheme
import com.airbnb.android.showkase.annotation.ShowkaseComposable

@Composable
fun PegasusActionButton(
    text: String,
    modifier: Modifier = Modifier,
    iconLeft: (@Composable () -> Unit)? = null,
    iconRight: (@Composable () -> Unit)? = null,
    loading: Boolean = false,
    backgroundColor: Color? = MaterialTheme.colorScheme.primary,
    enabled: Boolean = true,
    description: String? = null,
    onClick: () -> Unit = { }
) {

    val elementsColor = MaterialTheme.colorScheme.onPrimary

    val backgroundButtonColor = backgroundColor ?: Color.Transparent

    Button(modifier = modifier,
        colors = ButtonDefaults.buttonColors(
            backgroundColor = backgroundButtonColor, contentColor = elementsColor
        ),
        elevation = ButtonDefaults.elevation(1.dp),
        contentPadding = PaddingValues(),
        shape = MaterialTheme.shapes.medium,
        onClick = { if (enabled) onClick() }) {

        val backgroundModifier = if (enabled && loading.not()) {
            if (backgroundColor != null) {
                Modifier.background(backgroundColor)
            } else {
                Modifier.background(color = MaterialTheme.colorScheme.outline)
            }
        } else {
            Modifier.background(color = MaterialTheme.colorScheme.outline)
        }

        Box(
            modifier = backgroundModifier
                .fillMaxWidth()
                .then(modifier),
            contentAlignment = Alignment.Center,
        ) {
            Row(
                horizontalArrangement = Arrangement.Center, modifier = modifier.padding(
                    start = 16.dp, end = 16.dp, top = 16.dp, bottom = 16.dp
                )
            ) {

                if (loading) {
                    PegasusActionButtonLoading()
                } else {
                    iconLeft?.invoke()

                    AppButtonText(description, text, elementsColor)

                    iconRight?.invoke()
                }
            }
        }

    }
}

@Composable
fun PegasusActionButtonLoading(tint: Color = LocalContentColor.current.copy(alpha = LocalContentAlpha.current)) {
    val infiniteTransition = rememberInfiniteTransition(label = "")
    val rotation by infiniteTransition.animateFloat(
        initialValue = 0F,
        targetValue = 360F,
        animationSpec = infiniteRepeatable(
            animation = tween(1000, easing = LinearEasing),
        ), label = ""
    )
    Icon(
        imageVector = Icons.Rounded.Refresh,
        contentDescription = null,
        tint = tint,
        modifier = Modifier
            .padding(end = 4.dp)
            .graphicsLayer {
                rotationZ = rotation
            }
    )
}

@Composable
fun PegasusActionButtonIcon(
    imageVector: ImageVector,
    tint: Color = LocalContentColor.current.copy(alpha = LocalContentAlpha.current)
) {
    Icon(
        imageVector = imageVector,
        contentDescription = null,
        tint = tint,
        modifier = Modifier.padding(end = 4.dp)
    )
}


@Composable
fun RowScope.AppButtonText(
    description: String?,
    text: String,
    elementsColor: Color = MaterialTheme.colorScheme.onPrimary,
    fontWeight: FontWeight = FontWeight.Bold
) {
    val commonTextModifier = Modifier.Companion
        .padding(horizontal = 4.dp)
        .align(Alignment.CenterVertically)
        .semantics {
            description?.let {
                contentDescription = description
            }
        }

    Text(
        text = text, style = MaterialTheme.typography.bodyLarge.copy(
            color = elementsColor, fontWeight = fontWeight
        ), modifier = commonTextModifier
    )

}

@Composable
@Preview
@ShowkaseComposable(name = "Pegasus Action Button", group = "Buttons")
fun PegasusActionButton_Preview() {
    PegasusTheme {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = MaterialTheme.colorScheme.surface)
        ) {
            Box(modifier = Modifier.padding(16.dp)) {
                PegasusActionButton(text = "This is a button, click me")
            }
        }
    }
}


@Composable
@Preview(uiMode = UI_MODE_NIGHT_YES)
@ShowkaseComposable(name = "Pegasus Action Button", group = "Buttons", styleName = "Dark")
fun PegasusActionButton_Dark_Preview() {
    PegasusTheme {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = MaterialTheme.colorScheme.surface)
        ) {
            Box(modifier = Modifier.padding(16.dp)) {
                PegasusActionButton(text = "This is a button, click me")
            }
        }
    }
}

@Composable
@Preview
@ShowkaseComposable(name = "Pegasus Action Button", group = "Buttons", styleName = "Icon Left")
fun PegasusActionButton_Icon_Left_Preview() {
    PegasusTheme {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = MaterialTheme.colorScheme.surface)
        ) {
            Box(modifier = Modifier.padding(16.dp)) {
                PegasusActionButton(text = "This is a button, click me", iconLeft = {
                    PegasusActionButtonIcon(Icons.Rounded.ShoppingCart)
                })
            }
        }
    }
}

@Composable
@Preview
@ShowkaseComposable(name = "Pegasus Action Button", group = "Buttons", styleName = "Icon Right")
fun PegasusActionButton_Icon_Right_Preview() {
    PegasusTheme {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = MaterialTheme.colorScheme.surface)
        ) {
            Box(modifier = Modifier.padding(16.dp)) {
                PegasusActionButton(text = "This is a button, click me", iconRight = {
                    PegasusActionButtonIcon(Icons.Rounded.ShoppingCart)
                })
            }
        }
    }
}


@Composable
@Preview
@ShowkaseComposable(name = "Pegasus Action Button", group = "Buttons", styleName = "Both Icons")
fun PegasusActionButton_Icons_Preview() {
    PegasusTheme {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = MaterialTheme.colorScheme.surface)
        ) {
            Box(modifier = Modifier.padding(16.dp)) {
                PegasusActionButton(text = "This is a button, click me",
                    iconLeft = {
                        PegasusActionButtonIcon(imageVector = Icons.Rounded.Save)
                    },
                    iconRight = {
                        PegasusActionButtonIcon(Icons.Rounded.ShoppingCart)
                    })
            }
        }
    }
}


@Composable
@Preview
@ShowkaseComposable(
    name = "Pegasus Action Button",
    group = "Buttons",
    styleName = "Active to Loading Preview"
)
fun PegasusActionButton_Active_To_Loading_Preview() {
    PegasusTheme {
        var loading by remember {
            mutableStateOf(false)
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = MaterialTheme.colorScheme.surface)
        ) {
            Box(modifier = Modifier.padding(16.dp)) {
                PegasusActionButton(text = "This is a button, click me",
                    iconLeft = {
                        PegasusActionButtonIcon(imageVector = Icons.Rounded.Save)
                    }, loading = loading, onClick = {
                        loading = loading.not()
                    }
                )
            }
        }
    }
}

