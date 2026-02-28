package ru.nickolay.roomtask.data.local.dto

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import ru.nickolay.roomtask.data.local.entity.BouquetCountEntity
import ru.nickolay.roomtask.data.local.entity.BouquetEntity
import ru.nickolay.roomtask.data.local.entity.FlowerEntity

data class BouquetWithFlowers(
    @Embedded val bouquet: BouquetEntity,
    @Relation(
        parentColumn = "bouquetId",
        entityColumn = "flowerId",
        associateBy = Junction(BouquetCountEntity::class)
    )
    val flowers: List<FlowerEntity>
)