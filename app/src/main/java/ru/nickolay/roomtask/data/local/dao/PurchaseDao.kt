package ru.nickolay.roomtask.data.local.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import ru.nickolay.roomtask.data.local.entity.BouquetCountEntity

@Dao
interface PurchaseDao {
    @Transaction
    suspend fun buyBouquet(bouquetId: Long) {
        val bouquetFlowers = getBouquetFlowers(bouquetId)

        bouquetFlowers.forEach { bf ->
            decreaseStock(bf.flowerId, bf.quantity)
        }
    }

    @Query("""
        SELECT * FROM bouquet_flowers
        WHERE bouquetId = :bouquetId
    """)
    suspend fun getBouquetFlowers(bouquetId: Long): List<BouquetCountEntity>

    @Query("""
        UPDATE stock
        SET quantity = quantity - :amount
        WHERE flowerId = :flowerId
    """)
    suspend fun decreaseStock(flowerId: Long, amount: Int)
}