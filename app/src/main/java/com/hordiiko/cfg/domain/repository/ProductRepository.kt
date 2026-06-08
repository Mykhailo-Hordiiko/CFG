package com.hordiiko.cfg.domain.repository

import com.hordiiko.cfg.domain.model.Product
import com.hordiiko.cfg.domain.model.ProductWithReviews
import kotlinx.coroutines.flow.Flow

interface ProductRepository {

    suspend fun loadProducts()

    fun observeProducts(): Flow<List<ProductWithReviews>>

    suspend fun getProductById(id: Long): Product?

    suspend fun updateProduct(
        id: Long,
        name: String,
        description: String
    )
}