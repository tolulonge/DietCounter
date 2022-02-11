package com.tolulonge.tracker_presentation.tracker_overview

import com.tolulonge.tracker_domain.model.TrackedFood

sealed class TrackerOverviewEvent {
    object onNextDayClick: TrackerOverviewEvent()
    object onPreviousDayClick: TrackerOverviewEvent()
    data class onToggleMealClick(val meal: Meal): TrackerOverviewEvent()
    data class onDeleteTrackedFoodClick(val trackedFood: TrackedFood): TrackerOverviewEvent()
    data class onAddFoodClick(val meal: Meal) : TrackerOverviewEvent()

}
