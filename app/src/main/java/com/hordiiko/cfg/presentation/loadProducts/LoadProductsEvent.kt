package com.hordiiko.cfg.presentation.loadProducts

sealed interface LoadProductsEvent {
    data object LoadProductsSuccess : LoadProductsEvent
}