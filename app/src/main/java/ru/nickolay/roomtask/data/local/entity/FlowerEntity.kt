package ru.nickolay.roomtask.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "flowers")
data class FlowerEntity(
    @PrimaryKey(autoGenerate = true) val flowerId: Long = 0,
    val name: String
)
