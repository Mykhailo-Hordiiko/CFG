package com.hordiiko.cfg.data.remote.dto

import com.google.gson.annotations.SerializedName

data class ProductDto(
    @SerializedName("product_id")
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
    val rating: Double,
    val reviews: List<ReviewDto>?
)