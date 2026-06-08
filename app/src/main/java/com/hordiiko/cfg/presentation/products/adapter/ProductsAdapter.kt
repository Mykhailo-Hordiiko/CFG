package com.hordiiko.cfg.presentation.products.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.hordiiko.cfg.databinding.ItemProductBinding
import com.hordiiko.cfg.presentation.products.model.ProductUiState

class ProductsAdapter(
    private val onItemClick: (Long) -> Unit
) : ListAdapter<ProductUiState, ProductViewHolder>(
    ProductDiffCallback()
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder =
        ProductViewHolder(
            ItemProductBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.bind(getItem(position), onItemClick)
    }
}