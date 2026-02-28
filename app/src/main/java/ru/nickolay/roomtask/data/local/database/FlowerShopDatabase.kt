package ru.nickolay.roomtask.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import ru.nickolay.roomtask.data.local.dao.BouquetDao
import ru.nickolay.roomtask.data.local.dao.PurchaseDao
import ru.nickolay.roomtask.data.local.dao.SetupDao
import ru.nickolay.roomtask.data.local.entity.BouquetCountEntity
import ru.nickolay.roomtask.data.local.entity.BouquetEntity
import ru.nickolay.roomtask.data.local.entity.FlowerEntity
import ru.nickolay.roomtask.data.local.entity.StockEntity

@Database(
    entities = [
        FlowerEntity::class,
        StockEntity::class,
        BouquetEntity::class,
        BouquetCountEntity::class
    ],
    version = 1
)
abstract class FlowerShopDatabase: RoomDatabase() {
    abstract fun bouquetDao(): BouquetDao
    abstract fun purchaseDao(): PurchaseDao
    abstract fun setupDao(): SetupDao
}