package com.mordaski.challenge.common.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface CacheDao {

    @Insert
    suspend fun insert(cache: CacheEntity)

    @Query("SELECT * FROM cache")
    suspend fun getAllUsers(): CacheEntity?
}