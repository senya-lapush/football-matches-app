package com.example.footballmatches.domain

import androidx.lifecycle.LiveData

interface Repository {

    val matches: LiveData<NetworkResult<List<MatchEntity>>>
    suspend fun loadMatches()
}