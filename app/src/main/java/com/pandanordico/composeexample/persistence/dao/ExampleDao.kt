package com.pandanordico.composeexample.persistence.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.pandanordico.composeexample.persistence.entity.ExampleEntity

@Dao
interface ExampleDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(exampleEntity: ExampleEntity)

    @Query("SELECT * FROM example")
    suspend fun getAll(): MutableList<ExampleEntity>?

    @Delete
    suspend fun delete(exampleEntity: ExampleEntity)
}