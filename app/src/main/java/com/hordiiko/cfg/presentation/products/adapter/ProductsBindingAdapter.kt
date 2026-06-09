package com.hordiiko.cfg.presentation.products.adapter

import android.graphics.Color
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.hordiiko.cfg.R
import com.hordiiko.cfg.presentation.products.model.ProductUiState

@BindingAdapter("items")
fun bindItems(
    recyclerView: RecyclerView,
    items: List<ProductUiState>?
) {
    val adapter: ProductsAdapter? = recyclerView.adapter as? ProductsAdapter
    adapter?.submitList(items.orEmpty())
}

@BindingAdapter("imageUrl")
fun bindImageUrl(
    imageView: ImageView,
    imageUrl: String
) {
    Glide.with(imageView)
        .load(imageUrl)
        .placeholder(android.R.drawable.ic_menu_gallery)
        .error(android.R.drawable.ic_menu_report_image)
        .into(imageView)
}

@BindingAdapter("availability")
fun bindAvailability(
    textView: TextView,
    availability: Boolean
) {
    if (availability) {
        textView.text = textView.context.getString(R.string.available)
        textView.setTextColor(Color.GREEN)
    } else {
        textView.text = textView.context.getString(R.string.unavailable)
        textView.setTextColor(Color.GRAY)
    }
}