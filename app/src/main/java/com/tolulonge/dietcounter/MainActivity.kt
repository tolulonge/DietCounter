package com.tolulonge.dietcounter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.ui.Modifier
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
import com.tolulonge.onboarding_presentation.activity.ActivityScreen
import com.tolulonge.onboarding_presentation.age.AgeScreen
import com.tolulonge.onboarding_presentation.gender.GenderScreen
import com.tolulonge.onboarding_presentation.goal.GoalScreen
import com.tolulonge.onboarding_presentation.height.HeightScreen
import com.tolulonge.onboarding_presentation.nutrient_goal.NutrientGoalScreen
import com.tolulonge.onboarding_presentation.weight.WeightScreen
import com.tolulonge.onboarding_presentation.welcome.WelcomeScreen
import dagger.hilt.android.AndroidEntryPoint
import okhttp3.Route

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DietCounterTheme {
                val navController = rememberNavController()
                val scaffoldState = rememberScaffoldState()
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    scaffoldState = scaffoldState
                ) {
                    NavHost(navController = navController, startDestination = WELCOME){
                        composable(WELCOME){
                            WelcomeScreen(onNavigate = navController::navigate)
                        }
                        composable(AGE){
                            AgeScreen(scaffoldState = scaffoldState, onNavigate = navController::navigate)
                        }
                        composable(GENDER){
                            GenderScreen(onNavigate = navController::navigate)

                        }
                        composable(HEIGHT){
                            HeightScreen(
                                scaffoldState = scaffoldState,
                                onNavigate = navController::navigate
                            )
                        }
                        composable(WEIGHT){
                            WeightScreen(
                                scaffoldState = scaffoldState,
                                onNavigate = navController::navigate
                            )
                        }
                        composable(NUTRIENT_GOAL){
                            NutrientGoalScreen(
                                scaffoldState = scaffoldState,
                                onNavigate = navController::navigate
                            )
                        }
                        composable(ACTIVITY){
                            ActivityScreen(
                                onNavigate = navController::navigate
                            )
                        }
                        composable(GOAL){
                            GoalScreen(
                                onNavigate = navController::navigate
                            )
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
}