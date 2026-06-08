package com.hordiiko.cfg.presentation.products

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.hordiiko.cfg.domain.repository.ProductRepository
import com.hordiiko.cfg.presentation.products.mapper.toUiState
import com.hordiiko.cfg.presentation.products.model.ProductsUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.map
import javax.inject.Inject

@HiltViewModel
class ProductsViewModel @Inject constructor(
    private val productRepository: ProductRepository
) : ViewModel() {

    val uiState: LiveData<ProductsUiState> = productRepository.observeProducts()
        .map { productsWithReviews ->
            ProductsUiState(
                productsWithReviews
                    .map { productWithReviews ->
                        productWithReviews.toUiState()
                    }
            )
        }
        .asLiveData()
}