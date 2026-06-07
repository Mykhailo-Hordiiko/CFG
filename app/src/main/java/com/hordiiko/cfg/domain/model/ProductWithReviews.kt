package com.hordiiko.cfg.domain.model

data class ProductWithReviews(
    val product: Product,
    val reviews: List<Review>
)