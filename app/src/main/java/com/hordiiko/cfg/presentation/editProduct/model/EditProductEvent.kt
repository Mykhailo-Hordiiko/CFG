package com.hordiiko.cfg.presentation.editProduct.model

sealed interface EditProductEvent {
    data object EditProductSuccess : EditProductEvent
}