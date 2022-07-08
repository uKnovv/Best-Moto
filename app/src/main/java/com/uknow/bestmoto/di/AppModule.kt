package com.uknow.bestmoto.di

import com.uknow.bestmoto.usecase.GetGoodsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideGetBikesListUseCase(): GetGoodsUseCase {
        return GetGoodsUseCase()
    }

}