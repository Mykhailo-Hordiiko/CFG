package com.hordiiko.cfg.presentation.products

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.hordiiko.cfg.R
import com.hordiiko.cfg.databinding.FragmentProductsBinding
import com.hordiiko.cfg.presentation.navigation.PRODUCT_ID_KEY
import com.hordiiko.cfg.presentation.products.adapter.ProductsAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProductsFragment : Fragment(R.layout.fragment_products) {

    private val viewModel: ProductsViewModel by viewModels()

    private var _binding: FragmentProductsBinding? = null
    private val binding: FragmentProductsBinding
        get() = requireNotNull(_binding)

    private val productsAdapter = ProductsAdapter(::navigateToEditProduct)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _binding = FragmentProductsBinding.bind(view)

        binding.productsRecyclerView.adapter = productsAdapter

        observeUiState()
    }

    override fun onDestroyView() {
        binding.productsRecyclerView.adapter = null
        _binding = null

        super.onDestroyView()
    }

    private fun observeUiState() {
        viewModel.uiState.observe(viewLifecycleOwner) { uiState ->
            binding.uiState = uiState
        }
    }

    private fun navigateToEditProduct(productId: Long) {
        findNavController().navigate(
            R.id.action_products_fragment_to_edit_product_fragment,
            bundleOf(
                PRODUCT_ID_KEY to productId
            )
        )
    }
}