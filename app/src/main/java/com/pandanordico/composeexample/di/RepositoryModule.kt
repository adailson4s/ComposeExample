package com.pandanordico.composeexample.di

import com.pandanordico.composeexample.persistence.dao.ExampleDao
import com.pandanordico.composeexample.repository.ExampleRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideExampleRepository(
        exampleDao: ExampleDao
    ): ExampleRepository = ExampleRepository(exampleDao)
}