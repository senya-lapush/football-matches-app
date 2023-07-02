package com.example.footballmatches.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.footballmatches.domain.usecases.GetMatchesUseCase
import com.example.footballmatches.domain.usecases.LoadMatchesUseCase
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class MatchViewModel @Inject constructor(
    private val loadMatchesUseCase: LoadMatchesUseCase,
    private val getMatchesUseCase: GetMatchesUseCase
): ViewModel() {

    val matches = getMatchesUseCase()

    fun loadMatches() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                loadMatchesUseCase()
            } catch (ce: CancellationException) {
                throw ce
            } catch (e: Exception) {

            }
        }
    }
}