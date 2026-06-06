package com.hordiiko.cfg.data.remote.api

import com.hordiiko.cfg.data.remote.dto.ProductDto
import retrofit2.http.GET

interface ProductApi {

    @GET("api/products")
    suspend fun getProducts(): List<ProductDto>
}