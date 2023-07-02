package com.example.footballmatches.domain.usecases

import com.example.footballmatches.domain.Repository
import javax.inject.Inject

class LoadMatchesUseCase @Inject constructor(
    private val repository: Repository
) {
    suspend operator fun invoke() = repository.loadMatches()
}