package com.mordaski.challenge.common.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "cache")
data class CacheEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val name: String,
)
