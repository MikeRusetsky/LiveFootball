package com.mikerusetsky.livefootball.ui.settings

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mikerusetsky.livefootball.data.settings.SettingsRepository
import com.mikerusetsky.livefootball.domain.Settings
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

class SettingsViewModel @Inject constructor(
    private val settingsRepository: SettingsRepository
): ViewModel() {

    private val state = MutableStateFlow(State())
    fun observeUi() = state.asStateFlow()

    init {
        viewModelScope.launch {
            val settings = settingsRepository.get()
            state.update { it.copy(settings = settings) }
        }
    }

    fun darkModeChanged(darkMode: Boolean) {
        viewModelScope.launch {
            val settings = settingsRepository.get().copy(isDarkMode = darkMode)
            settingsRepository.set(settings)
            state.update { it.copy(settings = settings) }
        }
    }

}

data class State(
    val settings: Settings? = null
)