package com.hordiiko.cfg.data.mapper

import com.hordiiko.cfg.data.local.entity.ProductEntity
import com.hordiiko.cfg.data.local.entity.ReviewEntity
import com.hordiiko.cfg.data.local.relation.ProductWithReviewsEntity
import com.hordiiko.cfg.data.remote.dto.ProductDto
import com.hordiiko.cfg.data.remote.dto.ReviewDto
import com.hordiiko.cfg.domain.model.Product
import com.hordiiko.cfg.domain.model.ProductWithReviews
import com.hordiiko.cfg.domain.model.Review

fun ProductDto.toEntity(): ProductEntity =
    ProductEntity(
        id = id,
        name = name,
        description = description,
        price = price,
        unit = unit,
        image = image,
        discount = discount,
        availability = availability,
        brand = brand,
        category = category,
        rating = rating
    )

fun ReviewDto.toEntity(productId: Long): ReviewEntity =
    ReviewEntity(
        productId = productId,
        userId = userId,
        rating = rating,
        comment = comment
    )


fun ProductEntity.toDomain(): Product =
    Product(
        id = id,
        name = name,
        description = description,
        price = price,
        unit = unit,
        image = image,
        discount = discount,
        availability = availability,
        brand = brand,
        category = category,
        rating = rating
    )

fun ReviewEntity.toDomain(): Review =
    Review(
        userId = userId,
        rating = rating,
        comment = comment
    )

fun ProductWithReviewsEntity.toDomain(): ProductWithReviews =
    ProductWithReviews(
        product = product.toDomain(),
        reviews = reviews.map { it.toDomain() }
    )