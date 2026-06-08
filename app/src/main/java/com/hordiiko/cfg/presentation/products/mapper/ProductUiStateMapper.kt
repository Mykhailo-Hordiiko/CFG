package com.hordiiko.cfg.presentation.products.mapper

import com.hordiiko.cfg.domain.model.Product
import com.hordiiko.cfg.domain.model.ProductWithReviews
import com.hordiiko.cfg.domain.model.Review
import com.hordiiko.cfg.presentation.products.model.ProductUiState
import java.util.Locale

fun ProductWithReviews.toUiState(): ProductUiState =
    ProductUiState(
        id = product.id,
        categoryBrandText = "${product.category} - ${product.brand}",
        imageUrl = product.image,
        name = product.name,
        description = product.description,
        availability = product.availability,
        priceWithDiscountText = product.calculatePriceWithDiscount().toPriceText(),
        priceText = product.price.toPriceText(),
        discountText = "-${product.discount}%",
        unit = product.unit,
        ratingText = "${product.rating} ★",
        reviewsText = reviews.toReviewsText()
    )

private fun Product.calculatePriceWithDiscount(): Double =
    price * (100 - discount) / 100

private fun Double.toPriceText(): String =
    "%.2f".format(Locale.getDefault(), this)

private fun List<Review>.toReviewsText(): String =
    joinToString(
        separator = "\n\n"
    ) { review ->
        "${review.userId} - ${review.rating} ★\n${review.comment}"
    }