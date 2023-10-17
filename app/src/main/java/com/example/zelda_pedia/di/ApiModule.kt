package com.example.zelda_pedia.di

import com.example.zelda_pedia.Repository
import com.example.zelda_pedia.io.API
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApiModule {

    @Singleton
    @Provides
    fun provideApi() : API {
        return API.getUrl()
    }

    @Singleton
    @Provides
    fun provideRepository(
        api: API
    ) = Repository(api)

}