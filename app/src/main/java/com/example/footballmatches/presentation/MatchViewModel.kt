package com.example.footballmatches.presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.footballmatches.data.repository.RepositoryImpl
import com.example.footballmatches.domain.usecases.GetMatchesUseCase
import com.example.footballmatches.domain.usecases.LoadMatchesUseCase
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MatchViewModel(application: Application): AndroidViewModel(application) {

    private val repository = RepositoryImpl(application)

    private val loadMatchesUseCase = LoadMatchesUseCase(repository)
    private val getMatchesUseCase = GetMatchesUseCase(repository)

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