package com.black.cleanapp.di

import com.black.cleanapp.data.DefaultAppRepository
import com.black.cleanapp.domain.repository.AppRepo
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindAppRepository(defaultAppRepository: DefaultAppRepository): AppRepo
}