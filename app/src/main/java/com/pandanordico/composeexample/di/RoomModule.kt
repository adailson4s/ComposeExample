package com.pandanordico.composeexample.di

import android.content.Context
import androidx.room.Room
import com.pandanordico.composeexample.BuildConfig
import com.pandanordico.composeexample.persistence.DatabaseApp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {
    @Singleton
    @Provides
    fun provideRoomInstance(
        @ApplicationContext
        context: Context
    ) = Room.databaseBuilder(
        context,
        DatabaseApp::class.java,
        BuildConfig.DATABASE_NAME
    )
        .fallbackToDestructiveMigration()
        .build()

    @Singleton
    @Provides
    fun provideExampleDao(databaseApp: DatabaseApp) = databaseApp.exampleDao()

}