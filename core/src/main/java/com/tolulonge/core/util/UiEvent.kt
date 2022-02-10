package com.tolulonge.core.util

sealed class UiEvent {
    object Success: UiEvent()
    object NavigateUp: UiEvent()
    data class Navigate(val route: String) : UiEvent()
    data class ShowSnackbar(val message: UiText): UiEvent()
}
