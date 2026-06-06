package com.hordiiko.cfg.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "products")
data class ProductEntity(
    @PrimaryKey
    val id: Long,
    val name: String,
    val description: String,
    val price: Double,
    val unit: String,
    val image: String,
    val discount: Int,
    val availability: Boolean,
    val brand: String,
    val category: String,
    val rating: Double
)