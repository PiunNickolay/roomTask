package ru.nickolay.roomtask.data.local.entity

import androidx.room.Entity
import androidx.room.ForeignKey

@Entity(
    tableName = "bouquet_flowers",
    primaryKeys = ["bouquetId", "flowerId"],
    foreignKeys = [
        ForeignKey(
            entity = BouquetEntity::class,
            parentColumns = ["bouquetId"],
            childColumns = ["bouquetId"],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = FlowerEntity::class,
            parentColumns = ["flowerId"],
            childColumns = ["flowerId"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class BouquetCountEntity(
    val bouquetId: Long,
    val flowerId: Long,
    val quantity: Int
)
