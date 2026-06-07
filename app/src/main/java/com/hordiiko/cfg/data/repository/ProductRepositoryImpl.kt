package com.hordiiko.cfg.data.repository

import com.hordiiko.cfg.data.local.dao.ProductDao
import com.hordiiko.cfg.data.local.entity.ProductEntity
import com.hordiiko.cfg.data.local.entity.ReviewEntity
import com.hordiiko.cfg.data.mapper.toDomain
import com.hordiiko.cfg.data.mapper.toEntity
import com.hordiiko.cfg.data.remote.api.ProductApi
import com.hordiiko.cfg.data.remote.dto.ProductDto
import com.hordiiko.cfg.domain.model.ProductWithReviews
import com.hordiiko.cfg.domain.repository.ProductRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class ProductRepositoryImpl @Inject constructor(
    private val productApi: ProductApi,
    private val productDao: ProductDao
) : ProductRepository {

    override suspend fun loadProducts() {
        val products: List<ProductDto> = productApi.getProducts()

        val productEntities: List<ProductEntity> = products
            .map { product ->
                product.toEntity()
            }
        val reviewEntities: List<ReviewEntity> = products
            .flatMap { product ->
                product.reviews.orEmpty()
                    .map { review ->
                        review.toEntity(product.id)
                    }
            }

        productDao.insertProductsWithReviews(
            products = productEntities,
            reviews = reviewEntities
        )
    }

    override fun observeProducts(): Flow<List<ProductWithReviews>> =
        productDao.observeProducts()
            .map { productsWithReviews ->
                productsWithReviews
                    .map { productWithReviews ->
                        productWithReviews.toDomain()
                    }
            }
}