package com.pandanordico.composeexample.persistence

import androidx.room.Database
import androidx.room.RoomDatabase
import com.pandanordico.composeexample.BuildConfig
import com.pandanordico.composeexample.persistence.dao.ExampleDao
import com.pandanordico.composeexample.persistence.entity.ExampleEntity

@Database(
    entities = [
        ExampleEntity::class
    ],
    version = BuildConfig.DATABASE_VERSION
)
abstract class DatabaseApp : RoomDatabase() {
    abstract fun exampleDao(): ExampleDao
}