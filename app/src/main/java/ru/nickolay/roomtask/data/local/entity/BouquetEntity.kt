package ru.nickolay.roomtask.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "bouquets")
data class BouquetEntity(
    @PrimaryKey(autoGenerate = true) val bouquetId: Long = 0,
    val name: String,
    val decoration: String = "Крафтовая бумага"
)
