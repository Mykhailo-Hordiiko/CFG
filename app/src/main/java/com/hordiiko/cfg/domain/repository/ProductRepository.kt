package com.hordiiko.cfg.domain.repository

import com.hordiiko.cfg.domain.model.ProductWithReviews
import kotlinx.coroutines.flow.Flow

interface ProductRepository {

    suspend fun loadProducts()

    fun observeProducts(): Flow<List<ProductWithReviews>>
}