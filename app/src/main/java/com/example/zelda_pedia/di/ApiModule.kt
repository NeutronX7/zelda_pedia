package com.example.zelda_pedia.di

import com.example.zelda_pedia.io.API
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object ApiModule {

    @Provides
    fun provideApi() : API{
        return API.getUrl()
    }

}