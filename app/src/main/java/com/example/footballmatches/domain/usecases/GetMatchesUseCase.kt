package com.example.footballmatches.domain.usecases

import com.example.footballmatches.domain.Repository
import javax.inject.Inject

class GetMatchesUseCase @Inject constructor(
    private val repository: Repository
) {
    operator fun invoke() = repository.matches
}