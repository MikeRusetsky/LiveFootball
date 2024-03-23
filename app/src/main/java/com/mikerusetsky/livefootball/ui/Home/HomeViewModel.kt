package com.mikerusetsky.livefootball.ui.Home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mikerusetsky.livefootball.data.MatchesRepository
import com.mikerusetsky.livefootball.domain.Match
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

class HomeViewModel @Inject constructor(
    private val repository: MatchesRepository
) : ViewModel() {

    private val state = MutableStateFlow(State())
    fun observeUi() = state.asStateFlow()

    init {
        getMatches()
    }

    private fun getMatches(){
        viewModelScope.launch {
            val result = repository.getMatches()
            state.update { it.copy(items = result) }
        }
    }
}

data class State(
    val items: List<Match> = emptyList()
)
