package ru.nickolay.roomtask.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import ru.nickolay.roomtask.data.local.entity.BouquetCountEntity
import ru.nickolay.roomtask.data.local.entity.BouquetEntity
import ru.nickolay.roomtask.data.local.entity.FlowerEntity
import ru.nickolay.roomtask.data.local.entity.StockEntity

@Dao
interface SetupDao {
    @Insert
    suspend fun insertFlowers(flowers: List<FlowerEntity>)

    @Insert
    suspend fun insertStock(stock: List<StockEntity>)

    @Insert
    suspend fun insertBouquet(bouquet: BouquetEntity): Long

    @Insert
    suspend fun insertBouquetCounts(counts: List<BouquetCountEntity>)

    @Query("SELECT COUNT(*) FROM flowers")
    suspend fun flowersCount(): Int
}