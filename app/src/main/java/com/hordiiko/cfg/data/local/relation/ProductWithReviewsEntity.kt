package com.hordiiko.cfg.data.local.relation

import androidx.room.Embedded
import androidx.room.Relation
import com.hordiiko.cfg.data.local.entity.ProductEntity
import com.hordiiko.cfg.data.local.entity.ReviewEntity

data class ProductWithReviewsEntity(
    @Embedded
    val product: ProductEntity,
    @Relation(
        parentColumn = "id",
        entityColumn = "productId"
    )
    val reviews: List<ReviewEntity>
)