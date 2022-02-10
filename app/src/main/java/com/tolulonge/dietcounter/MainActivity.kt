package com.tolulonge.dietcounter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.tolulonge.dietcounter.ui.theme.DietCounterTheme
import com.tolulonge.onboarding_presentation.welcome.WelcomeScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DietCounterTheme {
                WelcomeScreen()
            }
        }
    }
}