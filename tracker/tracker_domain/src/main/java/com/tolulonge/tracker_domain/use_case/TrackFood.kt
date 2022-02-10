package com.tolulonge.tracker_domain.use_case

import com.tolulonge.tracker_domain.model.MealType
import com.tolulonge.tracker_domain.model.TrackableFood
import com.tolulonge.tracker_domain.model.TrackedFood
import com.tolulonge.tracker_domain.repository.TrackerRepository
import java.time.LocalDate
import kotlin.math.roundToInt

class TrackFood (
    private val repository: TrackerRepository
)
{
    suspend operator fun invoke(
       food: TrackableFood,
       amount: Int,
       mealType: MealType,
       date: LocalDate
    ){
       repository.insertTrackedFood(
           TrackedFood(
               name = food.name,
               carbs = ((food.carbsPer100g/ 100f) * 100).roundToInt(),
               protein = ((food.proteinPer100g/ 100f) * 100).roundToInt(),
               fat = ((food.fatPer100g/ 100f) * 100).roundToInt(),
               calories = ((food.caloriesPer100g/ 100f) * 100).roundToInt(),
               imageUrl = food.imageUrl,
               mealType = mealType,
               date = date,
               amount = amount
           )
       )
    }
}