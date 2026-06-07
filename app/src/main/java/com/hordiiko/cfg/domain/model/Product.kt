package com.hordiiko.cfg.domain.model

data class Product(
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