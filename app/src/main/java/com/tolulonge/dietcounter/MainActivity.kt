package com.tolulonge.dietcounter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.tolulonge.core.navigation.Route.ACTIVITY
import com.tolulonge.core.navigation.Route.AGE
import com.tolulonge.core.navigation.Route.GENDER
import com.tolulonge.core.navigation.Route.GOAL
import com.tolulonge.core.navigation.Route.HEIGHT
import com.tolulonge.core.navigation.Route.NUTRIENT_GOAL
import com.tolulonge.core.navigation.Route.SEARCH
import com.tolulonge.core.navigation.Route.TRACKER_OVERVIEW
import com.tolulonge.core.navigation.Route.WEIGHT
import com.tolulonge.core.navigation.Route.WELCOME
import com.tolulonge.dietcounter.navigation.navigate
import com.tolulonge.dietcounter.ui.theme.DietCounterTheme
import com.tolulonge.onboarding_presentation.welcome.WelcomeScreen
import okhttp3.Route

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DietCounterTheme {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = WELCOME){
                    composable(WELCOME){
                        WelcomeScreen(onNavigate = navController::navigate)
                    } 
                    composable(AGE){
                        
                    } 
                    composable(GENDER){
                        
                    } 
                    composable(HEIGHT){
                        
                    }
                    composable(WEIGHT){
                        
                    } 
                    composable(NUTRIENT_GOAL){
                        
                    } 
                    composable(ACTIVITY){
                        
                    }
                    composable(GOAL){
                        
                    }
                    composable(TRACKER_OVERVIEW){
                        
                    }
                    composable(SEARCH){
                        
                    }
                }
            }
        }
    }
}