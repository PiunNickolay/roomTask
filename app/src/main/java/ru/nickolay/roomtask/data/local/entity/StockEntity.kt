package ru.nickolay.roomtask.data.local.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "stock",
    foreignKeys = [ForeignKey(
        entity = FlowerEntity::class,
        parentColumns = ["flowerId"],
        childColumns = ["flowerId"],
        onDelete = ForeignKey.CASCADE
    )]
)
data class StockEntity(
    @PrimaryKey val flowerId: Long,
    val quantity: Int
)
