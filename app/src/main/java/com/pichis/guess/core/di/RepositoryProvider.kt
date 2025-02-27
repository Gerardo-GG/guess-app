package com.pichis.guess.core.di

import com.google.ai.client.generativeai.GenerativeModel
import com.pichis.guess.data.ai.GeminiRepositoryImpl
import com.pichis.guess.domain.interfaces.GeminiRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryProvider {

    @Singleton
    @Provides
    fun geminiRepositoryProvider(model: GenerativeModel): GeminiRepository {
        return GeminiRepositoryImpl(model)
    }

}