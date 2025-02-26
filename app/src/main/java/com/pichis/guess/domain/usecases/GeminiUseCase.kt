package com.pichis.guess.domain.usecases

import com.pichis.guess.data.ai.GeminiRepositoryImpl
import com.pichis.guess.domain.interfaces.GeminiRepository
import javax.inject.Inject

class GeminiUseCase @Inject constructor(
    private val repository: GeminiRepositoryImpl
) {
    suspend operator fun invoke(prompt: String): Array<String> = repository.generateCardsText(prompt)
}