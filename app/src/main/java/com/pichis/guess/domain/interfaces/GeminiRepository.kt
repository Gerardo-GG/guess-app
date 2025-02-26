package com.pichis.guess.domain.interfaces

interface GeminiRepository {

    suspend fun generateCardsText(prompt: String): Array<String>

}