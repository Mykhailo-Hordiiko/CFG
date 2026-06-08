package com.hordiiko.cfg.presentation.products.adapter

import androidx.recyclerview.widget.DiffUtil
import com.hordiiko.cfg.presentation.products.model.ProductUiState

class ProductDiffCallback : DiffUtil.ItemCallback<ProductUiState>() {

    override fun areItemsTheSame(oldItem: ProductUiState, newItem: ProductUiState): Boolean =
        oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: ProductUiState, newItem: ProductUiState): Boolean =
        oldItem == newItem
}