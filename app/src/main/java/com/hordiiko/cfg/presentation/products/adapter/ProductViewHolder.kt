package com.hordiiko.cfg.presentation.products.adapter

import androidx.recyclerview.widget.RecyclerView
import com.hordiiko.cfg.databinding.ItemProductBinding
import com.hordiiko.cfg.presentation.products.model.ProductUiState

class ProductViewHolder(
    private val binding: ItemProductBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(
        uiState: ProductUiState,
        onItemClick: (Long) -> Unit
    ) {
        binding.uiState = uiState
        binding.root.setOnClickListener {
            onItemClick(uiState.id)
        }

        binding.executePendingBindings()
    }
}