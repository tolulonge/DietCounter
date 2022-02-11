package com.tolulonge.core.util

sealed class UiEvent {
    object NavigateUp: UiEvent()
    object Success : UiEvent()
    data class ShowSnackbar(val message: UiText): UiEvent()
}
