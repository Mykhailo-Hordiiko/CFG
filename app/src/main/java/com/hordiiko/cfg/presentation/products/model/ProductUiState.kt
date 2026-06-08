package com.hordiiko.cfg.presentation.products.model

data class ProductUiState(
    val id: Long,
    val categoryBrandText: String,
    val imageUrl: String,
    val name: String,
    val description: String,
    val availability: Boolean,
    val priceWithDiscountText: String,
    val priceText: String,
    val discountText: String,
    val unit: String,
    val ratingText: String,
    val reviewsText: String
)