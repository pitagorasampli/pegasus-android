package br.com.cogna.pegasus.components.button

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.cogna.pegasus.components.theme.PegasusTheme

@Composable
fun PegasusActionButton(
    text: String,
    modifier: Modifier = Modifier,
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

        val backgroundModifier = if (enabled) {
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
                horizontalArrangement = Arrangement.Center,
                modifier = modifier.padding(
                    start = 16.dp,
                    end = 16.dp,
                    top = 16.dp,
                    bottom = 16.dp
                )
            ) {

                AppButtonText(description, text, elementsColor)
            }
        }

    }
}


@Composable
fun RowScope.AppButtonText(
    description: String?,
    text: String,
    elementsColor: Color = MaterialTheme.colorScheme.onPrimary,
    fontWeight: FontWeight = FontWeight.Bold
) {
    val commonTextModifier = Modifier.Companion
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
fun PegasusActionButton_Preview() {
    PegasusTheme {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = MaterialTheme.colorScheme.surface)
        ) {
            Box(modifier = Modifier.padding(16.dp)) {
                var enabled by remember {
                    mutableStateOf(true)
                }
                PegasusActionButton(
                    text = "This is a button, click me",
                    enabled = enabled,
                    onClick = {
                        enabled = !enabled
                    })
            }
        }
    }
}

@Composable
@Preview(uiMode = UI_MODE_NIGHT_YES)
fun PegasusActionButton_Dark_Preview() {
    PegasusTheme {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = MaterialTheme.colorScheme.surface)
        ) {
            Box(modifier = Modifier.padding(16.dp)) {
                var enabled by remember {
                    mutableStateOf(true)
                }
                PegasusActionButton(
                    text = "This is a button, click me",
                    enabled = enabled,
                    onClick = {
                        enabled = !enabled
                    })
            }
        }
    }
}