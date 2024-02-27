package com.mikerusetsky.livefootball.ui.Home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mikerusetsky.livefootball.data.MatchesRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

class HomeViewModel @Inject constructor(
    private val repository: MatchesRepository
) : ViewModel() {

    fun getMatches(){
        viewModelScope.launch {
            val result = repository.getMatches()
            val a = 1
        }
    }


}