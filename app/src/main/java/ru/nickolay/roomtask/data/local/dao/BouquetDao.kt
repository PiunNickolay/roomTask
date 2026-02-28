package ru.nickolay.roomtask.data.local.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import ru.nickolay.roomtask.data.local.entity.BouquetCountEntity
import ru.nickolay.roomtask.data.local.entity.BouquetEntity
import ru.nickolay.roomtask.data.local.entity.StockEntity

@Dao
interface BouquetDao {
    @Query("SELECT * FROM bouquets")
    suspend fun getAllBouquets(): List<BouquetEntity>

    @Query("""
        SELECT * FROM bouquet_flowers
        WHERE bouquetId = :bouquetId
    """)
    suspend fun getFlowersForBouquet(bouquetId: Long): List<BouquetCountEntity>

    @Transaction
    suspend fun getAvailableBouquetCount(bouquetId: Long): Int {
        val bouquetFlowers = getFlowersForBouquet(bouquetId)

        return bouquetFlowers.minOf { bf ->
            val stock = getStockForFlower(bf.flowerId)
            stock.quantity/bf.quantity
        }
    }

    @Query("SELECT * FROM stock WHERE flowerId = :flowerId")
    suspend fun getStockForFlower(flowerId: Long): StockEntity
}