package com.pichis.guess.data.ai

import com.google.ai.client.generativeai.GenerativeModel
import com.pichis.guess.domain.interfaces.GeminiRepository
import javax.inject.Inject

class GeminiRepositoryImpl @Inject constructor(
    private val model: GenerativeModel
): GeminiRepository {

    override suspend fun generateCardsText(prompt: String): Array<String> {
        val requestPrompt = "Genera una lista de 20 palabras relacionadas con $prompt, con un formato [..., ..., ..., ...] y sin comillas"
        val response = model.generateContent(requestPrompt)
        val start = response.text?.indexOfFirst { it == '[' }
        val last = response.text?.indexOfLast { it == ']' }

        response.text?.let { result ->
            start?.let { startIndex ->
                last?.let { endIndex ->
                    val listString = result.substring(startIndex + 1, endIndex)
                    return listString.split(",").toTypedArray()
                }
            }
        }

        return emptyArray()
    }

}