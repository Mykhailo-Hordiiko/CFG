package com.hordiiko.cfg.presentation.loadProducts.model

sealed interface LoadProductsEvent {
    data object LoadProductsSuccess : LoadProductsEvent
}