package com.example.footballmatches.domain.usecases

import com.example.footballmatches.domain.Repository

class GetMatchesUseCase(private val repository: Repository) {
    operator fun invoke() = repository.matches
}