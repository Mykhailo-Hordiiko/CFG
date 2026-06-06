package com.hordiiko.cfg.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.hordiiko.cfg.data.local.dao.ProductDao
import com.hordiiko.cfg.data.local.entity.ProductEntity
import com.hordiiko.cfg.data.local.entity.ReviewEntity

@Database(
    entities = [
        ProductEntity::class,
        ReviewEntity::class
    ],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun productDao(): ProductDao
}