package ru.nickolay.roomtask.data.local

import android.util.Log
import ru.nickolay.roomtask.data.local.database.FlowerShopDatabase
import ru.nickolay.roomtask.data.local.entity.BouquetCountEntity
import ru.nickolay.roomtask.data.local.entity.BouquetEntity
import ru.nickolay.roomtask.data.local.entity.FlowerEntity
import ru.nickolay.roomtask.data.local.entity.StockEntity

suspend fun initDatabase(db: FlowerShopDatabase) {
    val dao = db.setupDao()

    if (dao.flowersCount() > 0) {
        Log.d("SHOP", "БД уже заполнена")
        return
    }

    dao.insertFlowers(
        listOf(
            FlowerEntity(name = "Белая роза"),
            FlowerEntity(name = "Тюльпан"),
            FlowerEntity(name = "Красная роза")
        )
    )

    dao.insertStock(
        listOf(
            StockEntity(1, 30),
            StockEntity(2, 10),
            StockEntity(3, 50)
        )
    )

    val bouquetId = dao.insertBouquet(
        BouquetEntity(name = "Весенний")
    )

    dao.insertBouquetCounts(
        listOf(
            BouquetCountEntity(bouquetId, 1, 3),
            BouquetCountEntity(bouquetId, 2, 2),
            BouquetCountEntity(bouquetId, 3, 10)
        )
    )
}