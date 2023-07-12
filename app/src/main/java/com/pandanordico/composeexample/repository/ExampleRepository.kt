package com.pandanordico.composeexample.repository

import com.pandanordico.composeexample.persistence.dao.ExampleDao
import com.pandanordico.composeexample.persistence.entity.ExampleEntity

class ExampleRepository constructor(
    private val exampleDao: ExampleDao
) {
    suspend fun insert(exampleEntity: ExampleEntity) = exampleDao.insert(exampleEntity)

    suspend fun getAll(): MutableList<ExampleEntity>? = exampleDao.getAll()

    suspend fun delete(exampleEntity: ExampleEntity) = exampleDao.delete(exampleEntity)
}