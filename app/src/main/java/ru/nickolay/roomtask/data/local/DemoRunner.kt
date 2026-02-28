package ru.nickolay.roomtask.data.local

import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import ru.nickolay.roomtask.data.local.database.FlowerShopDatabase

suspend fun runDemo(db: FlowerShopDatabase) = withContext(Dispatchers.IO) {

    val bouquetDao = db.bouquetDao()
    val purchaseDao = db.purchaseDao()
    val setupDao = db.setupDao()

    Log.d("SHOP", "START DEMONSTRATION")

    val bouquets = bouquetDao.getAllBouquets()
    Log.d("SHOP", "Букетов в базе: ${bouquets.size}")

    bouquets.forEach { bouquet ->
        val available = bouquetDao.getAvailableBouquetCount(bouquet.bouquetId)

        Log.d(
            "SHOP",
            "Букет '${bouquet.name}' доступен: $available шт"
        )
    }

    if (bouquets.isNotEmpty()) {
        val bouquet = bouquets.first()

        Log.d("SHOP", "Покупаем 1 букет '${bouquet.name}'")
        purchaseDao.buyBouquet(bouquet.bouquetId)

        Log.d("SHOP", "Остатки цветов после покупки:")

        val bouquetFlowers =
            bouquetDao.getFlowersForBouquet(bouquet.bouquetId)

        bouquetFlowers.forEach { bf ->
            val stock =
                bouquetDao.getStockForFlower(bf.flowerId)

            Log.d(
                "SHOP",
                "flowerId=${bf.flowerId}, остаток=${stock.quantity}"
            )
        }

        val newAvailable =
            bouquetDao.getAvailableBouquetCount(bouquet.bouquetId)

        Log.d(
            "SHOP",
            "После покупки букет '${bouquet.name}' доступен: $newAvailable шт"
        )
    }

    val flowers = setupDao.getAllFlowers()
    Log.d("SHOP", "Поля decoration и country")
    bouquets.forEach { Log.d("SHOP", "${it.name} - decoration: ${it.decoration}") }
    flowers.forEach { Log.d("SHOP", "${it.name} - country: ${it.country}") }

    Log.d("SHOP", "END OF THE DEMONSTRATION")
}