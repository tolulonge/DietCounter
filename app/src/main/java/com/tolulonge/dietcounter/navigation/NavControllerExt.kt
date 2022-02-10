package com.tolulonge.dietcounter.navigation

import androidx.navigation.NavController
import com.tolulonge.core.util.UiEvent

fun NavController.navigate(event: UiEvent.Navigate){
    this.navigate(event.route)
}