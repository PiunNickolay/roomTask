package ru.nickolay.roomtask

import android.app.Application
import androidx.room.Room
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import ru.nickolay.roomtask.data.local.MIGRATION_1_2
import ru.nickolay.roomtask.data.local.database.FlowerShopDatabase
import ru.nickolay.roomtask.data.local.initDatabase
import ru.nickolay.roomtask.data.local.runDemo

class App: Application() {
    override fun onCreate() {
        super.onCreate()

        val db = Room.databaseBuilder(
            applicationContext,
            FlowerShopDatabase::class.java,
            "flower_shop.db"
        )
            .addMigrations(MIGRATION_1_2)
            .build()

        CoroutineScope(Dispatchers.IO).launch {
            initDatabase(db)
            runDemo(db)
        }
    }
}