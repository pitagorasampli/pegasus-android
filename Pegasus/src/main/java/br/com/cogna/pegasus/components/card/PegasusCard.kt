package br.com.cogna.pegasus.components.card

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.cogna.pegasus.components.theme.PegasusTheme
import com.airbnb.android.showkase.annotation.ShowkaseComposable

@Composable
fun PegasusPrimaryCard(content: @Composable () -> Unit) {
    Card(
        shape = MaterialTheme.shapes.medium,
        backgroundColor = MaterialTheme.colorScheme.surface,
        contentColor = MaterialTheme.colorScheme.onSurface,
        content = content
    )
}

@Composable
@Preview
@ShowkaseComposable(name = "Pegasus Primary Card", group = "Cards", defaultStyle = true)
fun PegasusPrimaryCard_Preview() {
    PegasusTheme {
        PegasusPrimaryCard {
            Column(modifier = Modifier.padding(16.dp)) {
                Text(
                    style = MaterialTheme.typography.bodyLarge.copy(
                        color = MaterialTheme.colorScheme.onSurface, fontWeight = FontWeight.Bold
                    ), text = "Title"
                )

                Text(
                    modifier = Modifier.padding(top = 16.dp),
                    style = MaterialTheme.typography.bodyMedium.copy(
                        color = MaterialTheme.colorScheme.onSurface
                    ), text = "Subtitle"
                )
                Text(
                    modifier = Modifier.padding(top = 8.dp),
                    style = MaterialTheme.typography.bodySmall.copy(
                        color = MaterialTheme.colorScheme.onSurface
                    ), text = "Description of a long text"
                )


            }
        }
    }
}

