package com.jbpi.carbonintensity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.jbpi.carbonintensity.ui.compose.RegionsScreen
import com.jbpi.carbonintensity.ui.theme.CarbonIntensityTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        setContent {
            CarbonIntensityTheme {
                RegionsScreen()
            }
        }
    }
}
