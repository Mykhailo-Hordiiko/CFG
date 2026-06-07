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

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertProducts(products: List<ProductEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertReviews(reviews: List<ReviewEntity>)

    @Transaction
    suspend fun insertProductsWithReviews(
        products: List<ProductEntity>,
        reviews: List<ReviewEntity>
    ) {
        insertProducts(products)
        insertReviews(reviews)
    }

    @Transaction
    @Query("SELECT * FROM products ORDER BY id ASC")
    fun observeProducts(): Flow<List<ProductWithReviewsEntity>>
}