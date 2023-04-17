package br.com.cogna.pegasus

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Surface
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import br.com.cogna.pegasus.components.button.PegasusActionButton
import br.com.cogna.pegasus.components.theme.PegasusTheme
import br.com.cogna.pegasus.ui.getBrowserIntent
import com.airbnb.android.showkase.models.Showkase

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PegasusTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp)
                    ) {
                        PegasusActionButton(text = "Pegasus button")
                    }
                }
            }
        }
    }

    override fun onResume() {
        super.onResume()
        startActivity(Showkase.getBrowserIntent(this))
        finish()
    }
}

