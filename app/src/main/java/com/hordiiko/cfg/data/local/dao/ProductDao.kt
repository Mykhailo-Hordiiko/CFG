package com.hordiiko.cfg.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.hordiiko.cfg.data.local.entity.ProductEntity
import com.hordiiko.cfg.data.local.entity.ReviewEntity
import com.hordiiko.cfg.data.local.relation.ProductWithReviewsEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ProductDao {

    @Transaction
    suspend fun replaceProductsWithReviews(
        products: List<ProductEntity>,
        reviews: List<ReviewEntity>
    ) {
        deleteAllReviews()
        deleteAllProducts()

        insertProducts(products)
        insertReviews(reviews)
    }

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertProducts(products: List<ProductEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertReviews(reviews: List<ReviewEntity>)

    @Transaction
    @Query("SELECT * FROM products ORDER BY id ASC")
    fun observeProducts(): Flow<List<ProductWithReviewsEntity>>

    @Query("SELECT * FROM products WHERE id = :id")
    suspend fun getProductById(id: Long): ProductEntity?

    @Query("UPDATE products SET name = :name, description = :description WHERE id = :id")
    suspend fun updateProduct(
        id: Long,
        name: String,
        description: String
    )

    @Query("DELETE FROM products")
    suspend fun deleteAllProducts()

    @Query("DELETE FROM reviews")
    suspend fun deleteAllReviews()
}