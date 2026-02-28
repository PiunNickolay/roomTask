package ru.nickolay.roomtask.data.local

import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

val MIGRATION_1_2 = object : Migration(1,2) {
    override fun migrate(db: SupportSQLiteDatabase) {
        db.execSQL("""
            ALTER TABLE bouquets
            ADD COLUMN decoration TEXT NOT NULL DEFAULT 'Крафтовая бумага'
        """.trimIndent())

        db.execSQL("""
            ALTER TABLE flowers
            ADD COLUMN country TEXT NOT NULL DEFAULT 'Россия'
        """.trimIndent())
    }

}