package com.tolulonge.dietcounter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import coil.annotation.ExperimentalCoilApi
import com.tolulonge.core.domain.preferences.Preferences
import com.tolulonge.dietcounter.navigation.Route.ACTIVITY
import com.tolulonge.dietcounter.navigation.Route.AGE
import com.tolulonge.dietcounter.navigation.Route.GENDER
import com.tolulonge.dietcounter.navigation.Route.GOAL
import com.tolulonge.dietcounter.navigation.Route.HEIGHT
import com.tolulonge.dietcounter.navigation.Route.NUTRIENT_GOAL
import com.tolulonge.dietcounter.navigation.Route.SEARCH
import com.tolulonge.dietcounter.navigation.Route.TRACKER_OVERVIEW
import com.tolulonge.dietcounter.navigation.Route.WEIGHT
import com.tolulonge.dietcounter.navigation.Route.WELCOME
import com.tolulonge.dietcounter.ui.theme.DietCounterTheme
import com.tolulonge.onboarding_presentation.activity.ActivityScreen
import com.tolulonge.onboarding_presentation.age.AgeScreen
import com.tolulonge.onboarding_presentation.gender.GenderScreen
import com.tolulonge.onboarding_presentation.goal.GoalScreen
import com.tolulonge.onboarding_presentation.height.HeightScreen
import com.tolulonge.onboarding_presentation.nutrient_goal.NutrientGoalScreen
import com.tolulonge.onboarding_presentation.weight.WeightScreen
import com.tolulonge.onboarding_presentation.welcome.WelcomeScreen
import com.tolulonge.tracker_presentation.search.SearchScreen
import com.tolulonge.tracker_presentation.tracker_overview.TrackerOverviewScreen
import dagger.hilt.android.AndroidEntryPoint
import okhttp3.Route
import javax.inject.Inject

@ExperimentalComposeUiApi
@ExperimentalCoilApi
@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var preferences: Preferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val shouldShowOnboarding = preferences.loadShouldShowOnboarding()
        setContent {
            DietCounterTheme {
                val navController = rememberNavController()
                val scaffoldState = rememberScaffoldState()
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    scaffoldState = scaffoldState
                ) {
                    NavHost(navController = navController,
                        startDestination = if(shouldShowOnboarding) WELCOME else TRACKER_OVERVIEW){
                        composable(WELCOME){
                            WelcomeScreen { navController.navigate(GENDER) }
                        }
                        composable(AGE){
                            AgeScreen(scaffoldState = scaffoldState, onNextClick = { navController.navigate(
                                HEIGHT) })
                        }
                        composable(GENDER){
                            GenderScreen(onNextClick = { navController.navigate(AGE) })

                        }
                        composable(HEIGHT){
                            HeightScreen(
                                scaffoldState = scaffoldState,
                                onNextClick = { navController.navigate(WEIGHT) }
                            )
                        }
                        composable(WEIGHT){
                            WeightScreen(
                                scaffoldState = scaffoldState,
                                onNextClick = { navController.navigate(ACTIVITY) }
                            )
                        }
                        composable(NUTRIENT_GOAL){
                            NutrientGoalScreen(
                                scaffoldState = scaffoldState,
                                onNextClick = { navController.navigate(TRACKER_OVERVIEW) }
                            )
                        }
                        composable(ACTIVITY){
                            ActivityScreen(
                                onNextClick = { navController.navigate(GOAL) }
                            )
                        }
                        composable(GOAL){
                            GoalScreen(
                                onNextClick = { navController.navigate(NUTRIENT_GOAL) }
                            )
                        }
                        composable(TRACKER_OVERVIEW){
                            TrackerOverviewScreen(onNavigateToSearch =
                            { mealName, day, month, year ->
                                navController.navigate(SEARCH + "/$mealName" +
                                        "/$day" +
                                        "/$month" +
                                        "/$year"
                                )
                            })
                        }
                        composable(
                            route = "$SEARCH/{mealName}/{dayOfMonth}/{month}/{year}",
                            arguments = listOf(
                                navArgument("mealName"){
                                    type = NavType.StringType
                                },
                                navArgument("dayOfMonth"){
                                    type = NavType.IntType
                                },
                                navArgument("month"){
                                    type = NavType.IntType
                                },
                                navArgument("year"){
                                    type = NavType.IntType
                                }
                            )
                        ){
                            val mealName = it.arguments?.getString("mealName")!!
                            val dayOfMonth = it.arguments?.getInt("dayOfMonth")!!
                            val month = it.arguments?.getInt("month")!!
                            val year = it.arguments?.getInt("year")!!
                            SearchScreen(scaffoldState =scaffoldState,
                                mealName = mealName,
                                dayOfMonth = dayOfMonth,
                                month = month,
                                year = year,
                                onNavigateUp = {
                                    navController.navigateUp()

                                }
                            )
                        }
                    }
                }
            }
        }
    }
}