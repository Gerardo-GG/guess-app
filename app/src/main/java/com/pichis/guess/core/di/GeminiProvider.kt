package com.pichis.guess.core.di

import com.google.ai.client.generativeai.GenerativeModel
import com.pichis.guess.BuildConfig
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class GeminiProvider {

    @Singleton
    @Provides
    fun getGeminiProvider(): GenerativeModel {
        return  GenerativeModel(
            modelName = "gemini-1.5-pro-latest",
            apiKey = BuildConfig.GEMINI_API_KEY
        )
    }

}