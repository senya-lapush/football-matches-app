package com.example.footballmatches.domain.usecases

import com.example.footballmatches.domain.Repository

class LoadMatchesUseCase(private val repository: Repository) {
    suspend operator fun invoke() = repository.loadMatches()
}