package com.pichis.guess.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pichis.guess.domain.usecases.GeminiUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GeminiViewModel @Inject constructor(
    private val geminiUseCase: GeminiUseCase
): ViewModel() {

    fun getCardWithPrompt() {
        viewModelScope.launch {
            val arrayResponse = geminiUseCase("Lenguajes de programación")
            Log.d("RESPONSE", arrayResponse.contentToString())
        }
    }
}